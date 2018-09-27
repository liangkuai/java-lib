package sort.internal.comparison.selection;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/7/23
 */
public class SelectSortTest {

    public static void main(String[] args) {
        int[] origin = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        SelectSort s = new SelectSort();
        System.out.println(Arrays.toString(s.sort(origin)));
    }
}