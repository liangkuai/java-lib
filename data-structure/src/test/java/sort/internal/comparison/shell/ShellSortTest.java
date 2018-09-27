package sort.internal.comparison.shell;

import java.util.Arrays;


/**
 * @author liangkuai
 * @date 2018/7/29
 */
public class ShellSortTest {

    public static void main(String[] args) {
        int[] origin = {49, 38, 65, 97, 76, 13, 27, 49};

        ShellSort s = new ShellSort();
        System.out.println(Arrays.toString(s.sort(origin)));
    }
}