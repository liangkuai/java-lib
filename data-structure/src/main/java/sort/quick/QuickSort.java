package sort.quick;

/**
 * @author liangkuai
 * @date 2018/7/31
 */
public class QuickSort {

    public int[] sort(int[] origin) {
        sort(origin, 0, origin.length - 1);
        return origin;
    }

    public void sort(int[] origin, int head, int tail) {

        if (head >= tail)
            return;

        int j = partition(origin, head, tail);
        sort(origin, head, j);
        sort(origin, j + 1, tail);
    }

    public int partition(int[] origin, int head, int tail) {

        int i = head, j = tail + 1;
        int cp = origin[i];

        while (true) {
            while (origin[++i] < cp) {
                if (i >= tail)
                    break;
            }
            while (origin[--j] > cp) {
                if (j <= head)
                    break;
            }

            if (i >= j)
                break;

            int temp = origin[i];
            origin[i] = origin[j];
            origin[j] = temp;
        }

        origin[head] = origin[j];
        origin[j] = cp;

        return j;
    }
}
