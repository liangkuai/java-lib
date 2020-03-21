package collection.list;

import collection.MyCollection;

/**
 * 链表
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyList<E> extends MyCollection<E> {


    /**
     * 获取指定位置元素
     */
    E get(int index);



    /**
     * 插入到指定位置
     */
    void add(int index, E element);



    /**
     * 删除指定位置元素
     */
    E remove(int index);



    /**
     * 修改指定位置元素
     */
    E set(int index, E element);
}
