package string.sort.msd;

import java.util.Arrays;

/**
 * @author liukai
 * @date 18-9-21
 */
public class MSDSortTest {

    public static void main(String[] args) {
        String a[] = {"she", "sells", "seashells", "by", "the", "sea",
                "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};

        MSDSort s = new MSDSort();
        s.sort(a);
        System.out.println(Arrays.toString(a));
    }
}