package sort.radix;

import java.util.Arrays;

/**
 * @author liukai
 * @date 18-9-20
 */
public class RadixSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};

        RadixSort s = new RadixSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }
}