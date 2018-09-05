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
         * 以该节点为根的树的深度
         */
        public int depth;

        /**
         * 节点平衡因子
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
            current = balanced(current);

        return current;
    }


    /**
     * 删除，前驱节点代替
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node current, K key) {
        if (current == null) {
            return null;
        } else {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current.left = remove(current.left, key);
            } else if (cmp > 0) {
                current.right = remove(current.right, key);
            } else {
                // 删除命中

                if (current.left == null && current.right == null) {
                    return null;
                } else if (current.left == null) {
                    return current.right;
                } else if (current.right == null) {
                    return current.left;
                } else {
                    Node replace = current.left;

                    while (replace.right != null) {
                        replace = replace.right;
                    }
                    Node replaceLeftChild = replace.left;

                    if (replace != current.left) {
                        replace.left = current.left;
                        replace.left = adjust(replace.left, replaceLeftChild);
                    }
                    replace.right = current.right;
                    current = replace;
                }

            }
        }


        // 校验平衡因子
        recalculateFactor(current);
        if (Math.abs(current.factor) >= 2)
            current = balanced(current);

        return current;
    }

    private Node adjust(Node current, Node left) {
        if (current.right.right == null) {
            current.right = left;
        } else {
            adjust(current.right, left);
        }

        // 校验平衡因子
        recalculateFactor(current);
        if (Math.abs(current.factor) >= 2)
            current = balanced(current);

        return current;
    }


    /**
     * 重新计算节点的平衡因子，
     * 和以该节点为根的子树的深度
     */
    private void recalculateFactor(Node node) {
        if (node.left == null && node.right == null) {
            // 无孩子
            node.depth = 1;
            node.factor = 0;
        } else if (node.left == null) {
            // 仅有右子树
            node.depth = node.right.depth + 1;
            node.factor = - node.right.depth;
        } else if (node.right == null) {
            // 仅有左子树
            node.depth = node.left.depth + 1;
            node.factor = node.left.depth;
        } else {
            // 有两个子树
            if (node.left.depth >= node.right.depth) {
                node.depth = node.left.depth;
            } else {
                node.depth = node.right.depth;
            }
            node.factor = Math.abs(node.left.factor) - Math.abs(node.right.factor);
        }
    }


    /**
     * 平衡调整
     */
    private Node balanced(Node current) {
        if (current.factor == 2) {
            if (current.left.factor == 1) {
                current = rightRotate(current);
            } else if (current.left.factor == -1) {
                current.left = leftRotate(current.left);
                current = rightRotate(current);
            }
        } else if (current.factor == -2) {
            if (current.right.factor == -1) {
                current = leftRotate(current);
            } else if (current.right.factor == 1) {
                current.right = rightRotate(current.right);
                current = leftRotate(current);
            }
        }
        return current;
    }


    /**
     * 右旋，即将当前节点旋转为其左孩子节点的右子树
     */
    private Node rightRotate(Node node) {
        Node leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        // 更新平衡因子
        recalculateFactor(node);
        recalculateFactor(leftChild);

        return leftChild;
    }

    /**
     * 左旋，即将当前节点旋转为其右孩子节点的左子树
     */
    private Node leftRotate(Node node) {
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        // 更新平衡因子
        recalculateFactor(node);
        recalculateFactor(rightChild);

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
