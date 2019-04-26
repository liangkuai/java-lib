package search.bst;


import java.util.HashMap;

/**
 * @author liangkuai
 * @date 2018/8/12
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        HashMap<Integer, String> a = new HashMap<>();
        a.put(45, "e");
        a.put(13, "b");
        a.put(50, "f");
        a.put(3, "a");
        a.put(37, "d");
        a.put(100, "j");
        a.put(61, "g");
        a.put(24, "c");
        a.put(90, "i");
        a.put(78, "h");

        int searchKey = 12;

        BinarySearchTree<Integer, String> s = new BinarySearchTree<>();
        for (int key : a.keySet()) {
            s.put(key, a.get(key));
        }

        s.inorderTraversal(s.root);
        System.out.println("");

//        System.out.println(s.get(searchKey));
        s.remove(50);
//        System.out.println(s.get(searchKey));

        s.inorderTraversal(s.root);

    }

}