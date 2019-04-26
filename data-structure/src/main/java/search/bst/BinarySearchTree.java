package search.bst;

/**
 * 二叉排序树，升序
 *
 * @author liangkuai
 * @date 2018/8/12
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    public class Node {
        public K key;
        public V value;

        public Node leftChild;
        public Node rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node root;


    /**
     * 查找
     * 非递归
     */
    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0)
                current = current.leftChild;
            else if (cmp > 0)
                current = current.rightChild;
            else
                return current.value;
        }
        return null;
    }


    /**
     * 插入
     */
    public boolean put(K key, V value) {

        // 空树则新节点直接作为树的根节点
        if (root == null) {
            root = new Node(key, value);
            return true;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                parent = current;
                current = current.leftChild;
            } else if (cmp > 0) {
                parent = current;
                current = current.rightChild;
            } else {
                break;
            }
        }

        if (current != null) {
            // 相同 key，更新 value
            current.value = value;
        } else {
            // 插入新节点
            Node newNode = new Node(key, value);
            put(parent, key, newNode);
        }

        return true;
    }

    private void put(Node parent, K key, Node child) {
        int cmp = key.compareTo(parent.key);

        if (cmp < 0) {
            parent.leftChild = child;
        } else if (cmp > 0) {
            parent.rightChild = child;
        }
    }


    /**
     * 删除
     */
    public boolean remove(K key) {
        if (root == null)
            return true;

        Node parent = null;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                parent = current;
                current = current.leftChild;
            } else if (cmp > 0) {
                parent = current;
                current = current.rightChild;
            } else {
                break;
            }
        }

        if (current != null) {
            if (current == root) {
                // 删除根节点
                if (current.leftChild == null && current.rightChild == null) {
                    root = null;
                } else if (current.rightChild == null) {
                    root = current.leftChild;
                } else if (current.leftChild == null) {
                    root = current.rightChild;
                } else {
                    // 后继节点替换
                    Node succeed = current.rightChild;
                    Node sucParent = current;
                    while (succeed.leftChild != null) {
                        sucParent = succeed;
                        succeed = succeed.leftChild;
                    }

                    if (succeed.key.compareTo(sucParent.key) < 0) {
                        sucParent.leftChild = succeed.rightChild;
                    } else {
                        sucParent.rightChild = succeed.rightChild;
                    }

                    root = succeed;

                    succeed.leftChild = current.leftChild;
                    succeed.rightChild = current.rightChild;
                }
            } else {
                // 删除非根节点
                if (current.leftChild == null && current.rightChild == null) {
                    // 删除叶节点
                    put(parent, key, null);
                } else if (current.rightChild == null) {
                    // 删除仅有左子树的节点
                    put(parent, key, current.leftChild);
                } else if (current.leftChild == null) {
                    // 删除仅有右子树的节点
                    put(parent, key, current.rightChild);
                } else {
                    // 删除两个子树都不为空的节点
                    Node replace = current.leftChild;
                    Node replaceParent = current;
                    while (replace.rightChild != null) {
                        replaceParent = replace;
                        replace = replace.rightChild;
                    }

                    put(parent, key, replace);
                    put(replaceParent, replace.key, replace.leftChild);

                    replace.leftChild = current.leftChild;
                    replace.rightChild = current.rightChild;
                }
            }
        }
        return true;
    }


    /**
     * 中序遍历
     * 非递归
     */
    public void inorderTraversal(Node current) {
        if (current.leftChild != null) {
            inorderTraversal(current.leftChild);
        }

        System.out.print(current.value);

        if (current.rightChild != null) {
            inorderTraversal(current.rightChild);
        }
    }
}
