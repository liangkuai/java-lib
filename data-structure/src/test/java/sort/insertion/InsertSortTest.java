package sort.insertion;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/7/24
 */
public class InsertSortTest {

    public static void main(String[] args) {
        int[] origin = {49, 38, 65, 97, 76, 13, 27, 49};

        InsertSort s = new InsertSort();
        System.out.println(Arrays.toString(s.sort(origin)));
    }
}