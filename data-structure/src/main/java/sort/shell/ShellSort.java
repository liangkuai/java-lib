package sort.shell;

/**
 * @author liangkuai
 * @date 2018/7/29
 */
public class ShellSort {

    public int[] sort(int[] origin) {

        int k = 1;
        while (k < origin.length / 3)
            k = 3 * k + 1;

        while (k >= 1) {

            for (int i = k; i < origin.length; ++i) {
                int valueOfI = origin[i];

                int j = i;
                while ((j >= k) && (valueOfI < origin[j - k])) {
                    origin[j] = origin[j - k];
                    j -= k;
                }
                origin[j] = valueOfI;
            }

            k = k / 3;
        }

        return origin;
    }
}
