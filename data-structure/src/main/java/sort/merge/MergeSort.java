package sort.merge;

import java.util.Arrays;

/**
 * 归并排序，升序
 *
 * @author liangkuai
 * @date 2018/7/11
 */
public class MergeSort {

    /**
     * 将两个有序数组进行排序
     *
     * @param a 有序数组
     * @param b 有序数组
     *
     * @return 排序并合并后的数组
     */
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        for (; i < a.length && j < b.length; ++k) {
            if (a[i] < b[j])
                c[k] = a[i++];
            else
                c[k] = b[j++];
        }

        while (i < a.length) c[k++] = a[i++];
        while (j < b.length) c[k++] = b[j++];

        return c;
    }

    public int[] sort(int[] l) {
        if (l.length == 1) {
            return l;
        } else {
            int[] a = Arrays.copyOfRange(l, 0, (l.length / 2));
            int[] b = Arrays.copyOfRange(l, l.length / 2, l.length);
            int[] a2 = sort(a);
            int[] b2 = sort(b);
            return merge(a2, b2);
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};

        System.out.println(Arrays.toString(new MergeSort().sort(a)));
    }
}
