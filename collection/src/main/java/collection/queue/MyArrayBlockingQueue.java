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
     * 入队列的位置
     */
    private int putIndex;

    /**
     * 出队列的位置
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
     * 入队列的过程被锁定
     */
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();

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
        // 每次有元素存入队列时，唤醒一个阻塞的线程。
        notEmpty.signal();
    }




    @Override
    public E poll() {
        return null;
    }





    @Override
    public E peek() {
        return null;
    }
}
