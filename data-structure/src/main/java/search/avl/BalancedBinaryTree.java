package search.avl;

/**
 * @author liangkuai
 * @date 2018/8/16
 */
public class BalancedBinaryTree {

    public class Node<K, V> {
        public K key;
        public V value;

        public int factor;

        public Node<K, V> leftChild;
        public Node<K, V> rightChild;
    }

    public Node<Integer, Integer> root;


}
