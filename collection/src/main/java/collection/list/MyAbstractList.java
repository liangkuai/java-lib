package collection.list;

import collection.MyAbstractCollection;
import common.MyIterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public abstract class MyAbstractList<E> extends MyAbstractCollection<E>
        implements MyList<E> {


    @Override
    public MyIterator<E> iterator() {
        return new Itr();
    }

    /**
     * fail-fast 机制
     *
     * 记录 list 被修改次数。
     * 涉及到 list 集合内元素个数的操作，都会改变 modCount。
     *
     * @see Itr#checkForComodification()
     */
    protected transient int modCount = 0;

    private class Itr implements MyIterator<E> {
        /**
         * 指向下一个待操作的元素
         */
        int cursor = 0;

        /**
         * 指向当前待操作的元素
         */
        int lastRet = -1;

        /**
         * fail-fast 机制
         *
         * 在创建 iterator 时，保存当时 list 的 modCount
         */
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor++;
                return next;
            } catch (IndexOutOfBoundsException e) {
                // 元素下标越界，说明在使用 iterator 时，list 内容被修改过。
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        /**
         * 删除上一次 next() 方法返回的元素
         */
        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MyAbstractList.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * 每次通过 iterator 操作集合元素，
         * 都会比较创建 iterator 对象是的 modCount 和当前 modCount 是否相等。
         * 如果不相等，说明在使用 iterator 时，list 内容被修改过。
         */
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }



    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }





    /**
     * TODO: 实现
     */
    @Override
    public boolean equals(Object o) {

    }


    /**
     * 整个 list 的 hashcode 和所有元素有关
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        for (E e : this)
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());

        return hashCode;
    }
}
