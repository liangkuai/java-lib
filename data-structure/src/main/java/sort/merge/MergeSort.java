package sort.merge;


/**
 * 归并排序，升序
 *
 * @author liangkuai
 * @date 2018/7/11
 */
public class MergeSort {

    /**
     * 对无序数组进行归并排序
     *
     * @param l 无序数组
     *
     * @return 归并排序后的有序数组
     */
    public int[] sort(int[] l) {
        if (l.length == 1) {
            return l;
        } else {
            int[] a = subArray(l, 0, (l.length / 2));
            int[] b = subArray(l, l.length / 2, l.length);
            int[] a2 = sort(a);
            int[] b2 = sort(b);
            return merge(a2, b2);
        }
    }

    /**
     * 获取数组的部分，即子数组
     *
     * @param origin 源数组
     * @param from 起始下标
     * @param to 截止下标，但不包括此下标元素（可能越界）
     *
     * @return 子数组
     */
    private int[] subArray(int[] origin, int from, int to) {
        int[] target = new int[to - from];
        for (int i = 0; i < target.length; ++i) {
            target[i] = origin[from + i];
        }
        return target;
    }


    /**
     * 将两个有序数组进行排序并合并
     *
     * @param a 有序数组
     * @param b 有序数组
     *
     * @return 排序并合并后的数组
     */
    private int[] merge(int[] a, int[] b) {
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

}
