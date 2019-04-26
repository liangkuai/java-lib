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


    public V getByRecursive(K key) {
        return getByRecursive(root, key);
    }

    private V getByRecursive(Node root, K key) {
        if (root == null)
            return null;

        int cmp = key.compareTo(root.key);
        return cmp < 0 ? getByRecursive(root.left, key) : cmp > 0 ? getByRecursive(root.right, key) : root.val;
    }



    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
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


    public void putByRecursive(K key, V val) {
        putByRecursive(root, key, val);
    }

    private Node putByRecursive(Node root, K key, V val) {
        if (root == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(root.key);

        if (cmp < 0) {
            root.left = putByRecursive(root.left, key, val);
        } else if (cmp > 0) {
            root.right = putByRecursive(root.right, key, val);
        } else {
            root.val = val;
        }
        return root;
    }



    /**
     * 删除
     */
    public void remove(K key) {

    }


    /**
     * 中序遍历
     * 非递归
     */
    public void inorderTraversal(Node current) {

    }
}
