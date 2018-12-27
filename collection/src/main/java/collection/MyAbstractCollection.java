package collection;

import common.MyIterator;

/**
 * 集合基本实现
 *
 * @param <E>
 */
public abstract class MyAbstractCollection<E> implements MyCollection<E> {


    @Override
    public abstract MyIterator<E> iterator();


    @Override
    public abstract int size();

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }



    /**
     * 通过 iterator 遍历比较判断
     */
    @Override
    public boolean contains(Object o) {
        MyIterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }



    @Override
    public abstract boolean add(E e);



    /**
     * 通过 iterator 遍历比较判断
     */
    @Override
    public boolean remove(Object o) {
        MyIterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 通过 iterator 遍历删除
     */
    @Override
    public void clear() {
        MyIterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
