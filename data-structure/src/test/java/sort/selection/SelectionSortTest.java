package sort.selection;


import java.util.Arrays;

/**
 * @author liangkuai
 * @date 2018/7/23
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        int[] origin = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        SelectionSort s = new SelectionSort();
        System.out.println(Arrays.toString(s.sort(origin)));
    }
}