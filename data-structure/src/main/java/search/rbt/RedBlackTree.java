package search.rbt;

/**
 * 红黑树
 *
 * @author liangkuai
 * @date 2018/8/21
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    public Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    /**
     * 查找
     * 非递归
     */
    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }


    public void put(K key, V value) {

    }


    public void update(Node parent, K key, Node child) {
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = child;
        } else if (cmp > 0) {
            parent.right = child;
        }
    }


    public void leftRotate(Node parent, Node current) {
        update(parent, current.key, current.right);
        current.right = current.right.left;
        parent.left = current;
    }

    public void rightRotate(Node parent, Node current) {
        update(parent, current.key, current.left);
        current.left = current.left.right;

    }
}
