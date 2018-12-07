package collection.list;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public class MyArrayList {

    /**
     * 默认初始容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组（用于空实例）
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};



    /**
     * 保存实际数据的数组
     */
    transient Object[] elementData;

    /**
     * 数组所包含的元素个数
     */
    private int size;



    /**
     * 指定初始容量
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
}
