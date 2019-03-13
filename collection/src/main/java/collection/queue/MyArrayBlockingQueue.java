package collection.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liukai
 * @date 2019-02-22
 */
public class MyArrayBlockingQueue<E>
        extends MyAbstractQueue<E>
        implements MyBlockingQueue<E> {


    private final Object[] items;

    /**
     * 下一个入队列的元素存储的位置
     */
    private int putIndex;

    /**
     * 下一个出队列的元素存储的位置
     */
    private int takeIndex;

    private int count;



    private final ReentrantLock lock;

    private final Condition notEmpty;

    private final Condition notFull;






    public MyArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    public MyArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }



    /**
     * 入队列
     * 队列满，返回 false。
     *
     * 整个过程被锁定
     */
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();

        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length) {
                return false;
            } else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 队列不满时入队列
     */
    private void enqueue(E x) {
        final Object[] items = this.items;
        items[putIndex] = x;

        // 因为队列是基于数组实现，
        // 每次有元素存入队列时，需要判断是否已经到达数组尾。
        if (++putIndex == items.length)
            putIndex = 0;
        count++;

        // 当队列为空时，尝试从队列中取元素的线程会被阻塞。
        // 每次有元素入队列时，唤醒一个阻塞的线程。
        notEmpty.signal();
    }



    /**
     * 出队列
     *
     * 整个过程被锁定
     */
    @Override
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (count == 0) ? null : dequeue();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 队列不空时出队列
     */
    private E dequeue() {
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        // 队列中的引用设为 null
        items[takeIndex] = null;

        // 因为队列是基于数组实现，
        // 每次有元素出队列时，需要判断是否已经到达数组尾。
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;

        // 当队列为满时，尝试往队列中添加元素的线程会被阻塞。
        // 每次有元素出队列时，唤醒一个阻塞的线程。
        notFull.signal();
        return x;
    }



    @Override
    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return itemAt(takeIndex);
        } finally {
            lock.unlock();
        }
    }


    @SuppressWarnings("unchecked")
    private E itemAt(int i) {
        return (E) items[i];
    }
}
