package Tree.bst;

import Tree.AbstractTree;


/**
 * 二叉排序树，升序
 *
 * @author liukai
 * @date 2019-04-26
 */
public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractTree<K, V> {

    public class Node {
        private K key;
        private V val;

        private Node left;
        private Node right;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;


    @Override
    public V get(K key) {
        Node cur = root;

        while (cur != null) {
            int cmp = key.compareTo(cur.key);

            if (cmp < 0)
                cur = cur.left;
            else if (cmp > 0)
                cur = cur.right;
            else
                return cur.val;
        }
        return null;
    }


    @Override
    public V getByRecursion(K key) {
        return getByRecursion(root, key);
    }

    private V getByRecursion(Node root, K key) {
        if (root == null) return null;

        int cmp = key.compareTo(root.key);
        return cmp < 0 ? getByRecursion(root.left, key) : cmp > 0 ? getByRecursion(root.right, key) : root.val;
    }



    @Override
    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }

        Node node = root;
        while (true) {
            int cmp = key.compareTo(node.key);

            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new Node(key, val);
                    return;
                } else {
                    node = node.left;
                }
            } else if (cmp > 0) {
                if (node.right == null) {
                    node.right = new Node(key, val);
                    return;
                } else {
                    node = node.right;
                }
            } else {
                node.val = val;
                return;
            }
        }
    }


    @Override
    public void putByRecursion(K key, V val) {
        putByRecursion(root, key, val);
    }

    private Node putByRecursion(Node root, K key, V val) {
        if (root == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(root.key);

        if (cmp < 0) {
            root.left = putByRecursion(root.left, key, val);
        } else if (cmp > 0) {
            root.right = putByRecursion(root.right, key, val);
        } else {
            root.val = val;
        }
        return root;
    }



    /**
     * 删除
     */
    @Override
    public void remove(K key) {
        Node cur = root;
        Node par = null;

        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if (cmp == 0) {
                break;
            } else {
                par = cur;
                cur = cmp < 0 ? cur.left : cur.right;
            }
        }

        if (cur == root) {
            remove(cur);
            return;
        }

        if (par.left == cur) {
            par.left = remove(cur);
        } else {
            par.right = remove(cur);
        }
    }

    /**
     * @param cur 要删除的节点
     */
    private Node remove(Node cur) {
        if (cur == null) return null;

        if (cur.left == null) return cur.right;
        if (cur.right == null) return cur.left;

        // 要删除的节点具有两个子节点
        Node succssor = cur.right;
        Node par = null;
        while (succssor.left != null) {
            par = succssor;
            succssor = succssor.left;
        }

        succssor.left = cur.left;

        if (succssor != cur.right) {
            par.left = succssor.right;
            succssor.right = cur.right;
        }
        return succssor;
    }


    @Override
    public void removeByRecursion(K key) {
        removeByRecursion(root, key);
    }

    /**
     * @param cur 要删除的节点
     */
    private Node removeByRecursion(Node cur, K key) {
        if (cur == null) return null;

        int cmp = key.compareTo(cur.key);

        if (cmp < 0) {
            cur.left = removeByRecursion(cur.left, key);
        } else if (cmp > 0) {
            cur.right = removeByRecursion(cur.right, key);
        } else {
            if (cur.left == null) return cur.right;
            if (cur.right == null) return cur.left;

            // 要删除的节点具有两个子节点
            Node succssor = cur.right;
            Node par = null;
            while (succssor.left != null) {
                par = succssor;
                succssor = succssor.left;
            }

            succssor.left = cur.left;

            if (succssor != cur.right) {
                par.left = succssor.right;
                succssor.right = cur.right;
            }
            return succssor;
        }
        return cur;
    }



    /**
     * 中序遍历
     * 非递归
     */
    public void inorderTraversal(Node current) {

    }
}
