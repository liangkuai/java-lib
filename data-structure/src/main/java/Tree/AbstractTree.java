package Tree;

/**
 * @author liukai
 * @date 2019-04-26
 */
public abstract class AbstractTree<K, V> {

    /**
     * 查找，迭代
     */
    public abstract V get(K key);

    /**
     * 查找，递归
     */
    public abstract V getByRecursion(K key);


    /**
     *
     * 插入，迭代
     */
    public abstract void put(K key, V val);

    /**
     * 插入，递归
     */
    public abstract void putByRecursion(K key, V val);


    /**
     * 删除，迭代
     */
    public abstract void remove(K key);

    /**
     * 删除，递归
     */
    public abstract void removeByRecursion(K key);
}