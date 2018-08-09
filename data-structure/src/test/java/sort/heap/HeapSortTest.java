package sort.heap;

import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/8/7
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] a = {0, 49, 38, 65, 97, 76, 13, 27};

        HeapSort s = new HeapSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}