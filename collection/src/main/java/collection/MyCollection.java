package collection;

import common.MyIterable;
import common.MyIterator;

/**
 * 顶级接口
 *
 * 集合，声明了集合的基本操作
 *
 * @see common.MyIterable 集合都可以迭代
 */
public interface MyCollection<E> extends MyIterable<E> {


    @Override
    MyIterator<E> iterator();



    int size();

    boolean isEmpty();



    /**
     * 是否包含某个 object
     *
     * @param o TODO: 为什么参数 key 是 Object 对象
     */
    boolean contains(Object o);



    /**
     * 增加，增加到集合末尾
     */
    boolean add(E e);



    /**
     * 删除
     */
    boolean remove(Object o);

    /**
     * 清空
     */
    void clear();
}
