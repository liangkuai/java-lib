package collection.queue;

/**
 * 队列
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyQueue<E> {


    /**
     * 入队列
     */
    boolean offer(E e);



    /**
     * 出队列
     *
     * 如果队列为空，返回 null
     */
    E poll();


    /**
     * 获取队列头
     *
     * 如果队列为空，返回 null
     */
    E peek();
}
