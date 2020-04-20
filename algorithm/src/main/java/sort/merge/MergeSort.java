package sort.merge;


/**
 * 归并排序，升序
 *
 * @author liangkuai
 * @date 2018/7/11
 */
public class MergeSort {

    /* ------------------------ 递归 ------------------------ */

    /**
     * 对无序数组进行归并排序（递归）
     *
     * @param a 待排数组
     */
    public void sort(int[] a) {
        int len = a.length;
        if (len <= 1) return;

        int[] tmp = new int[len];
        sort(a, 0, len - 1, tmp);
    }

    /**
     * 递归对数组 a 的子区间 [start, end] 进行归并排序
     *
     * @param a 待排数组
     * @param start 待排子区间的第一个元素下标
     * @param end 待排子区间的最后一个元素下标
     * @param tmp 临时数组
     */
    private void sort(int[] a, int start, int end, int[] tmp) {
        if (start >= end) return;

        // 分两段分别递归
        int mid = (start + end) / 2;
        sort(a, start, mid, tmp);
        sort(a, mid + 1, end, tmp);

        // 如果数组的这个子区间已经有序，无需归并
        if (a[mid] <= a[mid + 1]) {
            return;
        }

        // 归并
        merge(a, start, mid + 1, end, tmp);
    }

    /**
     * 归并数组 a 的两段连续有序子区间 [start1, start2 - 1] 和 [start2, end2]
     *
     * @param a 待排数组
     * @param start1 左半段有序子区间的第一个元素下标
     * @param start2 右半段有序子区间的第一个元素下标
     * @param end2 右半段有序子区间的最后一个元素下标
     * @param tmp 临时数组
     */
    private void merge(int[] a, int start1, int start2, int end2, int[] tmp) {
        // start2 - 1 就是左半段有序子区间的最后一个元素下标
        int end1 = start2 - 1;
        int i = start1, j = start2, k = start1;

        while (i <= end1 && j <= end2) {
            // a[i] <= a[j]，使用 <= 可以保证排序的稳定性
            tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i <= end1) tmp[k++] = a[i++];
        while (j <= end2) tmp[k++] = a[j++];

        for (int l = start1; l <= end2; l++) {
            a[l] = tmp[l];
        }
    }


    /* ------------------------ 迭代 ------------------------ */

    /**
     * 对无序数组进行归并排序（迭代）
     *
     * @param a 待排数组
     */
    public void sortByIteration(int[] a) {
        int len = a.length;
        if (len <= 1) return;

        int[] tmp = new int[len];
        for (int i = 2; i < len * 2; i *= 2) {
            sortByIteration(a, i, tmp);
        }
    }

    /**
     * 对数组 a 的每 sublen 个元素进行归并排序
     *
     * @param a 待排数组
     * @param sublen 子区间元素数量
     * @param tmp 临时数组
     */
    private void sortByIteration(int[] a, int sublen, int[] tmp) {
        int len = a.length;

        for (int i = 0; i < len; i += sublen) {
            int right = i + sublen;
            int mid = i + sublen / 2;

            // 如果数组 a 的最后一部分不足 (sublen/2) 个，
            // [i, sublen/2 - 1] 已经有序，直接返回
            if (mid >= len) {
                continue;
            }

            // 如果数组 a 的最后一部分不足 sublen 个，
            // end 取最后一个元素下标
            int end = right > len ? (len - 1) : right - 1;

            // 如果数组的这个子区间已经有序，无需归并
            if (a[mid - 1] < a[mid]) {
                continue;
            }

            // 归并
            merge(a, i, mid, end, tmp);
        }
    }

}
