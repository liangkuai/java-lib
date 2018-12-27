package common;

/**
 * 可迭代的
 *
 * @param <T>
 */
public interface MyIterable<T> {

    /**
     * 生成迭代器
     */
    MyIterator<T> iterator();
}
