package sort.heap;

/**
 * 堆排序，升序
 *
 * @author liangkuai
 * @date 2018/8/7
 */
public class HeapSort {

    public int[] sort(int[] origin) {

        for (int i = (origin.length / 2); i > 0; --i) {
            adjust(origin, i, origin.length);
        }

        for (int i = origin.length; i > 1; --i) {
            int temp = origin[i - 1];
            origin[i - 1] = origin[0];
            origin[0] = temp;

            adjust(origin, 1, i - 1);
        }

        return origin;
    }

    public void adjust(int[] origin, int index, int len) {
        int val = origin[index - 1];
        int i;
        for (i = index * 2; i <= len; i *= 2) {
            if ((i < len) && (origin[i - 1] < origin[i]))
                ++i;
            if (val >= origin[i - 1])
                break;
            origin[index - 1] = origin[i - 1];
            index = i;
        }
        origin[index - 1] = val;
    }
}
