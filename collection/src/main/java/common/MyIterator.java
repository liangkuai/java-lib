package common;

/**
 * 迭代器
 *
 * @param <E>
 *
 * @author liangkuai
 * @date 2017/10/29
 */
public interface MyIterator<E> {

    boolean hasNext();

    E next();

    /**
     * 删除上一次 next() 方法返回的元素
     */
    void remove();
}
