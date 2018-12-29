package collection.list;

import common.MyIterator;

/**
 * 用于 list 的迭代器
 */
public interface MyListIterator<E> extends MyIterator<E> {

    E previous();
}
