package sort.bubble;

/**
 * @author liangkuai
 * @date 2018/8/4
 */
public class BubbleSort {

    public int[] sort(int[] origin) {
        for (int i = 1; i < origin.length; ++i) {
            for (int j = 0; j < (origin.length - i); ++j) {
                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j + 1];
                    origin[j + 1] = origin[j];
                    origin[j] = temp;
                }
            }
        }
        return origin;
    }
}
