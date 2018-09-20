package sort.bucket;

import java.util.Arrays;

/**
 * @author liukai
 * @date 18-9-20
 */
public class BucketSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};

        BucketSort s = new BucketSort();
        System.out.println(Arrays.toString(s.sort(a, 100)));
    }
}