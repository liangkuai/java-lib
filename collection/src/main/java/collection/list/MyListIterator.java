package collection.list;

import common.MyIterator;

/**
 * 用于 list 的迭代器
 */
public interface MyListIterator<E> extends MyIterator<E> {

    boolean hasPrevious();

    E previous();

    void set(E e);

    void add(E e);
}
