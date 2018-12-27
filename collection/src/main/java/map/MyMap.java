package map;

/**
 * map 顶级接口
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyMap<K, V> {

    int size();

    boolean isEmpty();



    /**
     * 查找
     *
     * @param key TODO: 为什么参数 key 是 Object 对象
     */
    V get(Object key);


    /**
     * 是否包含某个 object
     *
     * @param key TODO: 为什么参数 key 是 Object 对象
     */
    boolean containKey(Object key);



    /**
     * 增加
     */
    V put(K key, V value);



    /**
     * 删除
     *
     * @param key TODO: 为什么参数 key 是 Object 对象
     */
    V remove (Object key);

    /**
     * 清空
     */
    void clear();

}
