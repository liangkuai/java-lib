package search.avl;


/**
 * 平衡二叉树，升序
 *
 * @author liangkuai
 * @date 2018/8/16
 */
public class BalancedBinaryTree<K extends Comparable<K>, V> {

    public class Node {
        public K key;
        public V value;

        /**
         * 树的深度
         */
        public int depth;

        /**
         * 平衡因子
         */
        public int factor;

        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            depth = 1;
            factor = 0;
        }
    }


    public Node root;


    /**
     * 查找
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


    /**
     * 插入
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

     Node put(Node current, K key, V value) {
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
                return current;
            }
        }

        // 校验平衡因子
        recalculateFactor(current);
        if (Math.abs(current.factor) >= 2)
            current = adjust(current);

        return current;
    }

    private void recalculateFactor(Node node) {
        // depth
        if (node.left != null) {
            if (node.right != null) {
                // 有两个子树
                if (node.left.depth >= node.right.depth) {
                    node.depth = node.left.depth;
                } else {
                    node.depth = node.right.depth;
                }
                node.factor = Math.abs(node.left.factor) - Math.abs(node.right.factor);
            } else {
                // 仅有左子树
                node.depth = node.left.depth + 1;
                node.factor = node.left.depth;
            }
        } else {
            if (node.right != null) {
                // 仅有右子树
                node.depth = node.right.depth + 1;
                node.factor = 0 - node.right.depth;
            } else {
                node.depth = 1;
                node.factor = 0;
            }
        }
    }



    private Node adjust(Node current) {
        if (current.factor == 2) {
            if (current.left.factor == 1) {
                current = rightRotate(current);
                recalculateFactor(current);
                recalculateFactor(current.right);
            } else if (current.left.factor == -1) {
                current.left = leftRotate(current.left);
                current = rightRotate(current);
                recalculateFactor(current);
                recalculateFactor(current.right);
                recalculateFactor(current.left);
            }
        } else if (current.factor == -2) {
            if (current.right.factor == -1) {
                current = leftRotate(current);
                recalculateFactor(current);
                recalculateFactor(current.right);
            } else if (current.right.factor == 1) {
                current.right = rightRotate(current.right);
                current = leftRotate(current);
                recalculateFactor(current);
                recalculateFactor(current.right);
                recalculateFactor(current.left);
            }
        }
        return current;
    }


    /**
     * 单向右旋
     */
    private Node rightRotate(Node node) {
        Node leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        return leftChild;
    }

    /**
     * 单向左旋
     */
    private Node leftRotate(Node node) {
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        return rightChild;
    }


    /**
     * 中序遍历
     * 非递归
     */
    public void inorderTraversal(Node current) {
        if (current.left != null) {
            inorderTraversal(current.left);
        }

        System.out.print(current.value);

        if (current.right != null) {
            inorderTraversal(current.right);
        }
    }
}
