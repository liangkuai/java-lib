package sort.internal.comparison.bubble;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/8/4
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};

        BubbleSort s = new BubbleSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}