package locks;

import sun.misc.Unsafe;


/**
 * AQS
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public abstract class MyAbstractQueuedSynchronizer {

    /**
     * 同步状态
     */
    private volatile int state;


    /**
     * CLH 队列首尾
     *
     * CLH 队列的 head 是一个获得独占资源的线程。
     */
    private volatile Node head;
    private volatile Node tail;

    /**
     * CLH 队列节点
     */
    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;

        /**
         * 线程状态
         *
         * CANCELLED:   线程已被取消（等待超时或被中断）
         *
         * SIGNAL:      此状态表示当前线程的后继线程需要被 unpark（唤醒）
         *
         *              一般情况是：当前线程的后继线程处于 Waiting 状态，
         *              而当前线程被 release 或 cancel 掉，因此需要唤醒当前线程的后继线程。
         *
         * CONDITION:   此状态表示当前线程因为未满足 Condition 而被阻塞，
         *              在等待 Condition 唤醒
         *
         * PROPAGATE:   其他线程获取到 “共享锁”
         */
        static final int CANCELLED =  1;
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;

        /**
         * 当前线程状态，初始化值为 0
         */
        volatile int waitStatus;

        /**
         * 当前节点的前驱节点
         */
        volatile Node prev;

        /**
         * 当前节点的后继节点
         */
        volatile Node next;

        /**
         * 与当前节点关联的排队中的线程
         */
        volatile Thread thread;

        // nextWaiter 用于区别当前 CLH 队列是 “独占锁” 队列还是 “共享锁” 队列的标记。
        // 若 nextWaiter = SHARED，则 CLH 队列是 “独占锁” 队列；
        // 若 nextWaiter = EXCLUSIVE，(即 nextWaiter = null)，则 CLH 队列是 “共享锁” 队列。
        Node nextWaiter;


        Node() {
        }

        Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
        }

        /**
         * 获取前驱节点
         */
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }
    }



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * 如果当前同步状态的值等于 expect（期望值）
     * 原子地（CAS操作）将同步状态值设置为 update（给定值）
     */
    public boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }



    /**
     * 独占模式下，获取独占资源
     *
     * final 方法，不可被继承
     */
    public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
                acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            // 当前线程调用 seIfInterrupt() 中断自己
            //
            // 为什么当前线程要中断自己？
            // acquireQueued() 返回的是当前线程获取到了独占资源之后的中断状态，
            // 如果是 true，说明当前线程是被中断唤醒之后才获取到独占资源的；
            // 而真正的中断被屏蔽了，所以这里主动中断自己。
            selfInterrupt();
    }


    /**
     * 尝试获取独占资源
     *
     * 模板方法，由自定义同步器子类继承并重写
     */
    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }


    /**
     * 获取独占资源失败的线程，构造成一个独占式节点，添加到 CLH 队列尾部。
     *
     * 采用乐观并发控制方式保证线程安全
     *
     * private 方法，不可以被继承、外部访问
     */
    private Node addWaiter(Node mode) {
        // 构造独占式节点
        Node node = new Node(Thread.currentThread(), mode);

        Node pred = tail;

        // 如果尾结点不为空，以 CAS 操作快速尝试一次在尾部添加新节点，若 CAS 设置成功则返回。
        if (pred != null) {
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }

        // 如果尾节点为空，或者尝试一次添加到队列尾部失败；
        // 就采用乐观并发策略继续添加新节点。
        enq(node);
        return node;
    }


    /**
     * 向 CLH 队列尾部添加新节点
     *
     * 采用乐观并发控制方式：volatile 变量 + CAS 操作 + 自旋
     */
    private Node enq(final Node node) {
        // 自旋
        for (; ;) {
            Node t = tail;
            if (t == null) {
                // 如果当前 CLH 队列为空，先创建一个空节点，同时被 head 和 tail 引用
                // 因为 head 表示一个已经获取到独占资源的线程，可以用一个空节点表示。
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                // CAS 操作设置尾节点
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }


    /**
     * 在 CLH 队列中获取独占资源
     *
     * 当前线程添加到 CLH 队列之后，
     * 1. 检查当前 node 是否称为 CLH 队列的二号节点
     * 2. 如果是，尝试获取独占资源
     *      2.1 如果获取成功，设置当前 ndoe 成为 CLH 队列的 head，返回当前线程唤醒之后的中断状态；
     *      2.2 如果获取失败，继续下面的步骤。
     * 3. 如果不是，尝试阻塞当前线程，进入 Waiting 状态
     *      3.1 如果可以阻塞，就阻塞当前线程，直到唤醒之后获取中断状态；
     *      3.2 如果不可以阻塞，继续下面的步骤。
     * 4. 重复上述步骤
     */
    final boolean acquireQueued(final Node node, int arg) {
        // 标记是否成功拿到独占资源
        boolean failed = true;
        try {
            boolean interrupted = false;

            // 自旋
            for (; ; ) {
                final Node p = node.predecessor();

                // 如果前驱是 head，那么当前节点就是二号节点，可以尝试获取独占资源
                //
                // 如果获取独占资源失败，尝试阻塞当前线程进入 Waiting 状态
                if (p == head && tryAcquire(arg)) {
                    // 当前尝试获取独占资源成功，设置当前节点成为 head
                    setHead(node);

                    // 前驱 next 设置为 null，方便 GC
                    p.next = null;

                    failed = false;
                    return interrupted;
                }

                // 首先调用 shouldParkAfterFailedAcquire() 判断当前线程是否可以被阻塞进入 Waiting 状态。
                //
                // 如果 shouldParkAfterFailedAcquire() = false，当前线程不可以进入 Waiting 状态，那就继续自旋。
                //
                // 如果 shouldParkAfterFailedAcquire() = true，表示当前线程可以进入 Waiting 状态，
                // 调用 parkAndCheckInterrupt() 方法阻塞当前线程，并返回当前线程的中断状态。
                //
                //      如果 parkAndCheckInterrupt() = false，表示当前线程已经被唤醒，并且不是被中断唤醒，那就继续自旋。
                if (shouldParkAfterFailedAcquire(p, node) &&
                        parkAndCheckInterrupt())
                    // 如果 parkAndCheckInterrupt() 中返回 true，表示当前线程被中断唤醒；
                    // 将中断标志 interrupted 设为 true，继续自旋。
                    interrupted = true;
            }
        } finally {
            // 意外
            // 方法返回前，当前线程获取独占资源失败
            // TODO: 怎么可能？
//            if (failed)
//                cancelAcquire(node);
        }
    }

    /**
     * 设置 head
     *
     * 此处成为 head 的节点内的线程已经获取到了独占资源，并且正在运行中。
     * 所以可以将 node 内的 thread 变量设置为 null。
     */
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
    }

    /**
     * 当前线程获取独占资源失败后，判断当前线程是否应该阻塞
     *
     * 阻塞条件:
     * 1. 如果当前节点前驱的状态是 SIGNAL，表示当前线程需要被 unpark，直接返回 true
     * 2. 如果当前节点前驱的状态是 CANCELLED，说明前驱节点已经被取消，那就先前回溯找到一个有效的的节点作为前驱，并返回 false
     * 3. 如果当前节点前驱的状态不是 SIGNAL、CANCELLED，就设置前驱的状态为 SIGNAL，并返回 false
     *
     * @param pred 前驱
     * @param node 当前线程所在 node
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        // 获取前驱的状态
        int ws = pred.waitStatus;

        // 前驱状态为 SIGNAL，前驱释放独占资源后会通知后继（也就是当前 node）；
        // 当前线程可以安心的进入阻塞状态。
        if (ws == Node.SIGNAL)
            return true;

        if (ws > 0) {
            // 如果前驱是取消状态，那就一直往前找，直到找到最近一个是非取消状态的节点，
            // 把这个节点作为前驱，并排在它的后边。
            do {
                pred = pred.prev;
                node.prev = pred;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            // 此处条件是：ws = 0
            // 如果前驱的状态是 0 或者共享锁，那就把前驱的状态设置成 SIGNAL，
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }

    /**
     * 阻塞当前线程，让当前线程进入 Waiting 状态；在唤醒之后返回中断状态。
     *
     * 调用 LockSupport 类的 park() 方法阻塞当前线程，让当前线程进入 Waiting 状态！
     *
     * ****************************************************************************
     * 注意，当前线程就是在这里进入 Waiting 状态，直到被唤醒！
     *
     * 在当前线程进入 Waiting 状态之后，有两种情况会被唤醒：
     *      1. unpark() 唤醒。前驱线程释放独占资源后，通过 unpark() 方法唤醒当前线程。
     *      2. 中断唤醒。当前线程被中断。
     * ****************************************************************************
     *
     * 在当前线程被唤醒之后，返回中断状态。
     */
    private final boolean parkAndCheckInterrupt() {
        MyLockSupport.park(this);
        return Thread.interrupted();
    }


    /**
     * 中断当前线程
     */
    static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }





    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    static {
        // 使用 Unsafe 提供的 objectFieldOffset() 方法
        // 获取成员变量在内存中的偏移地址
        try {
            stateOffset = unsafe.objectFieldOffset(MyAbstractQueuedSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(MyAbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(MyAbstractQueuedSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("waitStatus"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }


    /**
     * 以 CAS 操作设置 head 指向的节点
     */
    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    /**
     * 以 CAS 操作设置 tail 指向的节点
     */
    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    /**
     * 以 CAS 操作设置 tail 指向的尾节点
     */
    private static final boolean compareAndSetWaitStatus(Node node,
                                                         int expect,
                                                         int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset, expect, update);
    }
}
