package search.bst;


/**
 * @author liangkuai
 * @date 2018/8/12
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        int[] a = {45, 52, 12, 3, 37, 100, 61, 24, 90, 78};
        int key = 12;

        BinarySearchTree s = new BinarySearchTree();
        for (int item : a) {
            s.put(item, item);
        }

        System.out.println(s.get(key));
        s.remove(12);
        System.out.println(s.get(key));
    }

}