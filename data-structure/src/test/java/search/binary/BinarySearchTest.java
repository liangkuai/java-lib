package search.binary;


/**
 * @author liangkuai
 * @date 2018/7/22
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] a = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        int key = 19;

        BinarySearch s = new BinarySearch();
        System.out.println(s.search(a, key));
    }
}