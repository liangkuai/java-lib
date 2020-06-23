package map;

/**
 * @author liangkuai
 * @date 2018/12/5
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

//    /**
//     * 默认的初始容量是 16
//     */
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大容量
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

//    /**
//     * 当桶（bucket）上的结点数大于这个值时，由链表转换为红黑树
//     */
//    static final int TREEIFY_THRESHOLD = 8;
//
//    /**
//     * 当桶（bucket）上的结点数小于这个值时，由红黑树转换为链表
//     */
//    static final int UNTREEIFY_THRESHOLD = 6;
//
//    /**
//     * 桶中结构转化为红黑树对应的 table 的最小大小
//     */
//    static final int MIN_TREELY_CAPACITY = 64;

    /**
     * 默认的负载因子
     *
     * 0.75 是对空间和时间效率的一个平衡选择
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;


    /**
     * 存储元素的数组，总是 2 的幂次倍
     */
    private Node<K, V>[] table;

//    /**
//     * 存放元素的个数，即键值对的数量，不是数组长度
//     */
//    private transient int size;
//
//    /**
//     * 每次扩容和更改 map 结构的计数器
//     */
//    private transient int modCount;
//
    /**
     * 哈希表 key-val 对数量的阈值，当实际 key-val 对数量（=数组大小*填充因子）超过阈值时，会进行扩容。
     */
    private int threshold;

    /**
     * 负载因子
     *
     * final 会影响到整个哈希表能够容纳的 key-val 对的最大数量，所以初始化之后不可修改。
     */
    private final float loadFactor;





    private class Node<K, V> implements MyMap.MyEntry<K, V> {

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }





    /**
     * 默认构造方法
     *
     * 1. 设置默认负载因子
     */
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    /**
     * 1. 设置阈值
     * 2. 设置默认负载因子
     *
     * @param initialCapacity 数组初始大小
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 1. 设置阈值
     * 2. 设置负载因子
     *
     * @param initialCapacity 数组初始大小
     * @param loadFactor      负载因子
     */
    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }


    /**
     * 计算大于等于 cap 的最小的2的整数次幂的数
     *
     * HashMap 构造函数允许用户传入的容量不是 2 的 n 次方，
     * 因为它可以自动地将传入的容量转换为 2 的 n 次方。
     */
    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }




    /**
     * hash code 扰动函数
     *
     * 1. key.hashCode() 获取原始 hash code
     * 2. h ^ (h >>> 16) 高位参与运算，用来混合原始 hash code 的高位和低位，加大低位的随机性。
     *
     * @return 扰动之后的 hash code
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }




    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }


    private V putVal(int hash, K key, V value) {

    }




//    private final V putVal(int hash, K key, V value) {
//        Node<K, V>[] tab;
//        int n;
//
//        if ((tab = table) == null || (n = table.length) == 0)
//            tab = resize();
//    }
//
//
//    private final Node<K, V>[] resize() {
//        Node<K, V>[] oldTab = table;
//
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//
//        int newCap, newThr = 0;
//
//        if (oldCap > 0) {
//            // oldCap，扩容
//
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                // 超过最大值就不再扩充了，就只好随你碰撞去吧
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                    oldCap >= DEFAULT_INITIAL_CAPACITY) {
//                // 没超过最大值，就扩充为原来的 2 倍
//                newThr = oldThr << 1;
//            }
//        } else {
//            // oldCap <= 0，说明 map 刚实例化，还没有被使用
//
//            if (oldThr > 0) {
//                // oldThr > 0，说明实例化 map 时，设置了初始化的 bucket 数量
//                newCap = oldThr;
//            } else {
//                newCap = DEFAULT_INITIAL_CAPACITY;
//                newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//            }
//        }
//
//        if (newThr == 0) {
//            // 重新计算 threshold
//            float ft = (float) newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
//                    (int) ft : Integer.MAX_VALUE);
//        }
//
//        this.threshold = newThr;
//        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
//        table = newTab;
//
//        // 重哈希
//    }
}
