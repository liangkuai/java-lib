package search.bst;

/**
 * @author liangkuai
 * @date 2018/8/12
 */
public class BinarySearchTree {

    public class Node<K, V> {
        public K key;
        public V value;

        public Node<K, V> parent;
        public Node<K, V> leftChild;
        public Node<K, V> rightChild;
    }

    public Node<Integer, Integer> root;


    /**
     * 非递归
     */
    public Integer get(Integer key) {
        Node<Integer, Integer> current = root;

        while (current != null) {
            if (key.equals(current.key))
                return current.value;
            else if (key < current.key)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return null;
    }


    public void put(Integer key, Integer value) {

        if (root == null) {
            Node<Integer, Integer> node = new Node<>();
            node.key = key;
            node.value = value;
            root = node;
        } else {
            Node<Integer, Integer> parent = root.parent;
            Node<Integer, Integer> current = root;

            while (current != null) {
                if (key.equals(current.key))
                    break;
                else if (key < current.key) {
                    parent = current;
                    current = current.leftChild;
                } else{
                    parent = current;
                    current = current.rightChild;
                }
            }

            if (current != null) {
                current.value = value;
            } else {
                Node<Integer, Integer> node = new Node<>();
                node.key = key;
                node.value = value;
                node.parent = parent;

                if (key < parent.key)
                    parent.leftChild = node;
                else
                    parent.rightChild = node;
            }
        }

    }


    public void remove(Integer key) {
        Node<Integer, Integer> parent = root.parent;
        Node<Integer, Integer> current = root;

        while (current != null) {
            if (key.equals(current.key))
                break;
            else if (key < current.key) {
                parent = current;
                current = current.leftChild;
            } else{
                parent = current;
                current = current.rightChild;
            }
        }

        if (current != null) {
            if (current.leftChild == null && current.rightChild == null) {
                if (key < parent.key)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;

                current.parent = null;
            } else if (current.rightChild == null) {
                if (key < parent.key) {
                    parent.leftChild = current.leftChild;
                    current.leftChild.parent = parent;
                } else {
                    parent.rightChild = current.leftChild;
                    current.leftChild.parent = parent;
                }
                current.parent = null;
                current.leftChild = null;
                current.rightChild = null;
            } else if (current.leftChild == null) {
                if (key < parent.key) {
                    parent.leftChild = current.rightChild;
                    current.rightChild.parent = parent;
                } else {
                    parent.rightChild = current.rightChild;
                    current.rightChild.parent = parent;
                }

            } else {
                parent.leftChild = current.leftChild;
                current.leftChild.parent = parent;

                Node<Integer, Integer> maxNodeOnLeftChildTree = current.leftChild;
                while (maxNodeOnLeftChildTree.leftChild != null && maxNodeOnLeftChildTree.rightChild != null)
                    maxNodeOnLeftChildTree = maxNodeOnLeftChildTree.rightChild;

                maxNodeOnLeftChildTree.rightChild = current.rightChild;
                current.rightChild.parent = maxNodeOnLeftChildTree;

                current.parent = null;
                current.leftChild = null;
                current.rightChild = null;
            }
        }
    }
}
