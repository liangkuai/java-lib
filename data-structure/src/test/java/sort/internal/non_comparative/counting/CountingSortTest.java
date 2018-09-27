package sort.internal.non_comparative.counting;

import java.util.Arrays;

/**
 * @author liukai
 * @date 18-9-27
 */
public class CountingSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};

        CountingSort s = new CountingSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}