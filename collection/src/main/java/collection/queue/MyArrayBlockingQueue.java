package collection.queue;

/**
 * @author liukai
 * @date 2019-02-22
 */
public class MyArrayBlockingQueue<E>
        extends MyAbstractQueue<E>
        implements MyBlockingQueue<E> {


    private final Object[] items;

    private int putIndex;
    private int takeIndex;

    private int count;


    public MyArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    public MyArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
    }






    @Override
    public boolean offer(E e) {

        if (count == items.length) {
            return false;
        } else {
            enqueue(e);
            return true;
        }
    }

    public void enqueue(E x) {
        items[putIndex] = x;
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
