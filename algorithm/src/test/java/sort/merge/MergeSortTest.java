package sort.merge;


import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author liangkuai
 * @date 2018/7/22
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};

        MergeSort s = new MergeSort();
        s.sortByIteration(a);
        System.out.println(Arrays.toString(a));

        Random r = new Random();
        int[] b = IntStream.generate(() -> r.nextInt(10000000))
                .limit(10000000)
                .toArray();
        long start = System.currentTimeMillis();
        s.sortByIteration(b);
//        System.out.println(Arrays.toString(b));
        System.out.println(System.currentTimeMillis() - start);

        int[] c = Arrays.copyOf(b, b.length);
        start = System.currentTimeMillis();
        Arrays.sort(c);
//        System.out.println(Arrays.toString(c));
        System.out.println(System.currentTimeMillis() - start);

        Assert.assertEquals(Arrays.toString(b), Arrays.toString(c));
    }
}