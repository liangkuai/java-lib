package collection.set;

import collection.MyAbstractCollection;
import collection.MyCollection;
import common.MyIterator;

public abstract class MyAbstractSet<E> extends MyAbstractCollection<E> implements MyCollection<E> {





    /**
     * TODO: 实现
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * set 的 hashcode 和每一个元素有关，依赖元素 E 的 hashcode() 方法
     *
     * 通过 iterator 遍历
     */
    @Override
    public int hashCode() {
        int h = 0;
        MyIterator<E> i = iterator();
        while (i.hasNext()) {
            E obj = i.next();
            if (obj != null)
                h += obj.hashCode();
        }
        return h;
    }
}
