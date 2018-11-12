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
         */
        // 线程已被取消（等待超时或被中断）
        static final int CANCELLED =  1;

        // 表示当前线程的后继线程需要被 unpark（唤醒）
        // 当前线程的后继线程处于阻塞状态，而当前线程被 release 或 cancel 掉，因此需要唤醒当前线程的后继线程。
        static final int SIGNAL    = -1;

        // 线程在等待 Condition 唤醒
        static final int CONDITION = -2;

        // 其他线程获取到 “共享锁”
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
     * 独占模式下
     *
     * 获取独占资源
     *
     * final 方法，不可被继承
     */
    public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
                acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
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
     * node 在 CLH 队列中一直尝试获取独占资源。
     *
     * 如果当前线程获得独占资源，则返回；
     * 否则，当前线程进行 waiting
     */
    final boolean acquireQueued(final Node node, int arg) {
        // 标记是否成功拿到独占资源
        boolean failed = true;

        boolean interrupted = false;

        // 自旋
        for (; ; ) {
            final Node p = node.predecessor();

            // 如果前驱是 head，那么当前节点就是二号节点，可以尝试获取独占资源
            if (p == head && tryAcquire(arg)) {
                // 当前节点尝试获取独占资源成功，
                // 让当前节点成为 head
                setHead(node);

                // 前驱 next 设置为 null，方便 GC
                p.next = null;

                failed = false;
                return interrupted;
            }

            if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                interrupted = true;
        }

    }

    /**
     * 设置 head
     */
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
    }

    /**
     * 判断当前线程是否应该阻塞
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        // 获取前驱的状态
        int ws = pred.waitStatus;

        // 前驱状态为 SIGNAL，前驱释放独占资源后会通知后继（也就是当前 node）；
        // 当前线程可以安心的进入阻塞状态。
        if (ws == Node.SIGNAL)
            return true;

        if (ws > 0) {
        // 如果前驱是取消状态，那就一直往前找，直到找到最近一个正常等待的状态，并排在它的后边。
            do {
                pred = pred.prev;
                node.prev = pred;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            // 如果前驱正常，那就把前驱的状态设置成 SIGNAL，
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }

    /**
     * 让线程进入 waiting 状态
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
