/**
 * @author liangkuai
 * @date 2018/12/5
 */
public class MyHashMap<K, V> {

    /**
     * 默认的初始容量是 16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大容量
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 当桶（bucket）上的结点数大于这个值时，由链表转换为红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 当桶（bucket）上的结点数小于这个值时，由红黑树转换为链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 桶中结构转化为红黑树对应的 table 的最小大小
     */
    static final int MIN_TREELY_CAPACITY = 64;

    /**
     * 默认的填充因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 存储元素的数组，总是 2 的幂次倍
     */
    private transient Node<K, V>[] table;

    /**
     * 存放元素的个数，即键值对的数量，不是数组长度
     */
    private transient int size;

    /**
     * 每次扩容和更改 map 结构的计数器
     */
    private transient int modCount;

    /**
     * 临界值，当实际大小（=容量*填充因子）超过临界值时，会进行扩容
     */
    private int threshold;

    /**
     * 填充因子
     */
    private final float loadFactor;


    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * @param initialCapacity map 容量
     * @param loadFactor      装载因子
     */
    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);

        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }


    /**
     * HashMap 构造函数允许用户传入的容量不是 2 的 n 次方，
     * 因为它可以自动地将传入的容量转换为 2 的 n 次方。
     */
    private static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public V put(K key, V value) {
        return null;
    }

    private final V putVal(int hash, K key, V value) {
        Node<K, V>[] tab;
        int n;

        if ((tab = table) == null || (n = table.length) == 0)
            tab = resize();
    }


    private final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;

        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;

        int newCap, newThr = 0;

        if (oldCap > 0) {
            // oldCap，扩容

            if (oldCap >= MAXIMUM_CAPACITY) {
                // 超过最大值就不再扩充了，就只好随你碰撞去吧
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY) {
                // 没超过最大值，就扩充为原来的 2 倍
                newThr = oldThr << 1;
            }
        } else {
            // oldCap <= 0，说明 map 刚实例化，还没有被使用

            if (oldThr > 0) {
                // oldThr > 0，说明实例化 map 时，设置了初始化的 bucket 数量
                newCap = oldThr;
            } else {
                newCap = DEFAULT_INITIAL_CAPACITY;
                newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
            }
        }

        if (newThr == 0) {
            // 重新计算 threshold
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int) ft : Integer.MAX_VALUE);
        }

        this.threshold = newThr;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;

        // 重哈希
    }
}
