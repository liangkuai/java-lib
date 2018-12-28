package collection.queue;

import collection.MyCollection;

/**
 * 队列
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyQueue<E> extends MyCollection<E> {


    /**
     * 入队列
     */
    boolean offer(E e);



    /**
     * 出队列
     */
    E remove();

    E poll();


    /**
     * 获取队列头
     */
    E element();

    E peek();
}
