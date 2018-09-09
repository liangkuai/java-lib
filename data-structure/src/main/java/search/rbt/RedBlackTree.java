package search.rbt;

/**
 * 红黑树，升序
 *
 * @author liangkuai
 * @date 2018/8/21
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    public Node root;

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        /**
         * 节点颜色
         */
        private Color color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.color = Color.RED;

            // FIXME: 叶节点和 NULL 节点
            this.left = new Node(Color.BLACK);
            this.right = new Node(Color.BLACK);
        }

        public Node(Color color) {
            this.color = color;
        }

        public Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }


    /**
     * 节点颜色
     */
    public enum Color {
        BLACK,
        RED
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
        root = put(root, key, value);
        root.color = Color.BLACK;
    }

    private Node put(Node current, K key, V value) {

        // FIXME: 叶节点和 NULL 节点
        if (current == null || current.key == null) {
            return new Node(key, value);
        } else {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current.left = put(current.left, key, value);
            } else if (cmp > 0) {
                current.right = put(current.right, key, value);
            } else {
                current.value = value;
                return current;
            }
        }


        if (current.left.color == Color.RED && current.right.color == Color.RED) {
            // 叔父节点为红色

            if (current.left.left.color == Color.RED || current.left.right.color == Color.RED
                    || current.right.left.color == Color.RED || current.right.right.color == Color.RED) {
                current.color = Color.RED;
                current.left.color = Color.BLACK;
                current.right.color = Color.BLACK;
            }
        } else if (current.left.color == Color.RED) {
            // 叔父节点为黑色

            if (current.left.left.color == Color.RED) {
                current = rightRotate(current);
            } else

            if (current.left.right.color == Color.RED) {
                current.left = leftRotate(current.left);
                current = rightRotate(current);
            }
        } else if (current.right.color == Color.RED) {
            if (current.right.left.color == Color.RED) {
                current.right = rightRotate(current.right);
                current = leftRotate(current);
            } else

            if (current.right.right.color == Color.RED) {
                current = leftRotate(current);
            }
        }

        return current;
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
        current.color = Color.RED;

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
        current.color = Color.RED;

        return leftChild;
    }


    /**
     * 中序遍历
     * 非递归
     */
    public void inorderTraversal(RedBlackTree.Node current) {
        // FIXME: 叶节点和 NULL 节点
        if (current.left != null && current.left.key != null) {
            inorderTraversal(current.left);
        }

        System.out.print(current.value);

        // FIXME: 叶节点和 NULL 节点
        if (current.right != null && current.right.key != null) {
            inorderTraversal(current.right);
        }
    }
}