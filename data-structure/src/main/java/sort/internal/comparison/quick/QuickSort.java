package sort.internal.comparison.quick;

/**
 * @author liangkuai
 * @date 2018/7/31
 */
public class QuickSort {

    public int[] sort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }

    private void sort(int[] a, int head, int tail) {

        if (head >= tail)
            return;

        int pivotIndex = partition(a, head, tail);
        sort(a, head, pivotIndex - 1);
        sort(a, pivotIndex + 1, tail);
    }

    private int partition(int[] a, int head, int tail) {

        int i = head, j = tail + 1;
        int pivot = a[i];

        while (true) {
            while (a[++i] < pivot) {
                if (i >= tail)
                    break;
            }
            while (a[--j] > pivot) {
                if (j <= head)
                    break;
            }

            if (i >= j)
                break;

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        a[head] = a[j];
        a[j] = pivot;

        return j;
    }
}
