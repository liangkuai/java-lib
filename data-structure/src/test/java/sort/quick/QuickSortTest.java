package sort.quick;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/8/2
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};

        QuickSort s = new QuickSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}