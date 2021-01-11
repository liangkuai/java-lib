package sort.swap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        Random r = new Random();
        int[] a = IntStream.generate(() -> r.nextInt(10000000))
                .limit(1000000)
                .toArray();
        int[] b = Arrays.copyOf(a, a.length);

        long start = System.currentTimeMillis();
        QuickSort.sort(a);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println(System.currentTimeMillis() - start);

        Assert.assertEquals(Arrays.toString(a), Arrays.toString(b));
    }
}