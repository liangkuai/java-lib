package search.avl;


/**
 * @author liangkuai
 * @date 2018/8/16
 */
public class BalancedBinaryTree<K extends Comparable<K>, V> {

    public class Node {
        public K key;
        public V value;

        public int depth;
        public int factor;

        public Node leftChild;
        public Node rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            depth = 1;
            factor = 0;
        }
    }

    public Node root;


    public void put(K key, V value) {
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;
            put(parent, current, newNode);
        }
    }

    private void put(Node parent, Node current, Node newNode) {

        if (current == null) {
            put(parent, newNode);
            updateNode(parent);
        } else {
            if (newNode.key.compareTo(current.key) < 0) {
                put(current, current.leftChild, newNode);
            } else if (newNode.key.compareTo(current.key) > 0) {
                put(current, current.rightChild, newNode);
            } else {
                current.value = newNode.value;
            }

            if (Math.abs(current.factor) >= 2)
                adjust(parent, current);
        }
    }

    private void put(Node current, Node newNode) {
        if (newNode.key.compareTo(current.key) < 0) {
            current.leftChild = newNode;
        } else if (newNode.key.compareTo(current.key) > 0) {
            current.rightChild = newNode;
        }
    }

    private void updateNode(Node current) {
        // depth
        if (current.leftChild != null && current.rightChild == null) {
            current.depth = current.leftChild.depth + 1;
            current.factor = 1;
        } else if (current.leftChild == null && current.rightChild != null) {
            current.depth = current.rightChild.depth + 1;
            current.factor = -1;
        } else{
            if (current.leftChild.depth >= current.rightChild.depth)
                current.depth = current.leftChild.depth;
            else
                current.depth = current.rightChild.depth;

            current.factor = Math.abs(current.leftChild.factor) - Math.abs(current.rightChild.factor);
        }
    }

    private void adjust(Node parent, Node current) {

    }
}
