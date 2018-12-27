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

    void remove();
}
