package map;

/**
 * 顶级接口
 *
 * 键值对集合
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyMap<K, V> {


    /**
     * 键值对
     */
    interface MyEntry<K, V> {

        K getKey();

        V getValue();

        /**
         * 修改value
         *
         * @param value 新value
         * @return 原value
         */
        V setValue(V value);
    }



    int size();

    boolean isEmpty();



    /**
     * 查找
     *
     * @param key
     */
    V get(K key);


    /**
     * 是否包含某个 object
     *
     * @param key
     */
    boolean containKey(K key);



    /**
     * 增加
     */
    V put(K key, V value);



    /**
     * 删除
     *
     * @param key
     */
    V remove(K key);


    /**
     * 清空
     */
    void clear();

}
