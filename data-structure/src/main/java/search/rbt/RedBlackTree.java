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

        /**
         * false: 黑节点
         * true: 红节点
         */
        boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.color = true;
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


    public boolean put(K key, V value) {
        root = put(root, key, value);
    }

    public Node put(Node current, K key, V value) {

        if (current == null) {
            return new Node(key, value);
        } else {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current.left = put(current.left, key, value);
            } else if (cmp > 0) {
                current.right = put(current.right, key, value);
            } else {
                current.value = value;
            }
        }

        if (current.color) {
            // 红节点
            if (current.right.color) {
                return leftRotate(current);
            }
        } else {
            // 黑节点
            if (current.left.color && !current.right.color) {
                if (current.left.left.color) {

                    rightRotate(current);
                }
            }
            if (!current.left.color && current.right.color) {
                return leftRotate(current);
            } else if (current.left.color && current.right.color) {
                current.color = true;
                return current;
            }
        }
    }




    /**
     * 左旋，即将当前节点旋转为其右孩子节点的左子树
     */
    public Node leftRotate(Node current) {
        Node rightChild = current.right;

        current.right = rightChild.left;
        rightChild.left = current;

        // 旋转后，更换颜色
        rightChild.color = current.color;
        current.color = true;

        return rightChild;
    }

    /**
     * 右旋，即将当前节点旋转为其左孩子节点的右子树
     */
    public Node rightRotate(Node current) {
        Node leftChild = current.left;

        current.left = leftChild.right;
        leftChild.right = current;

        // 旋转后，更换颜色
        leftChild.color = current.color;
        current.color = true;

        return leftChild;
    }
}