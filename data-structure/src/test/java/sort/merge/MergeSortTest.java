package sort.merge;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/7/22
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};

        MergeSort s = new MergeSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}