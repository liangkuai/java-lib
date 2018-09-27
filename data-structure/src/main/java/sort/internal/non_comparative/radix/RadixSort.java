package sort.internal.non_comparative.radix;

/**
 * 基数排序，升序
 *
 * @author liukai
 * @date 18-9-20
 */
public class RadixSort {

    public int[] sort(int[] a) {

        int max = getMax(a);

        for (int digit = 1; max / digit != 0; digit *= 10) {

            int[] bucket = new int[10];
            int[] temp = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                bucket[(a[i] / digit) % 10]++;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = a.length - 1; i >= 0; i--) {
                temp[bucket[(a[i] / digit) % 10]-- - 1] = a[i];
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = temp[i];
            }

        }

        return a;
    }

    private int getMax(int[] a) {
        int max;
        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

}
