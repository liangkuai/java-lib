package search.avl;

import java.util.HashMap;


/**
 * @author liangkuai
 * @date 2018/9/2
 */
public class BalancedBinaryTreeTest {

    public static void main(String[] args) {
        HashMap<Integer, String> a = new HashMap<>();
        a.put(45, "e");
        a.put(52, "f");
        a.put(12, "b");
        a.put(3, "a");
        a.put(37, "d");
        a.put(100, "j");
        a.put(61, "g");
        a.put(24, "c");
        a.put(90, "i");
        a.put(78, "h");

        int searchKey = 12;

        BalancedBinaryTree<Integer, String> s = new BalancedBinaryTree<>();
        for (int key : a.keySet()) {
            s.put(key, a.get(key));
        }

        s.inorderTraversal(s.root);
        System.out.println("");

//        System.out.println(s.get(searchKey));
//        s.remove(12);
//        System.out.println(s.get(searchKey));

//        s.inorderTraversal(s.root);
    }

}