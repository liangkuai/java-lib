package sort.internal.comparison.shell;

/**
 * 希尔排序，升序
 * 
 * @author liangkuai
 * @date 2018/7/29
 */
public class ShellSort {

    public int[] sort(int[] a) {

        // 增量
        int k = 1;
        while (k < a.length / 3) {
            k = 3 * k + 1;
        }


        while (k >= 1) {
            for (int i = k; i < a.length; ++i) {

                // 待排元素的值
                int valueOfI = a[i];

                // 内循环中当前比较元素的下标
                int j = i;

                // 内循环
                // 对有序部分，从后往前比较；
                // 若待排元素的值小于当前比较元素的值，则将当前元素后移。
                while ((j >= k) && (valueOfI < a[j - k])) {
                    a[j] = a[j - k];
                    j -= k;
                }

                // 确定待排元素的位置后，赋值。
                a[j] = valueOfI;
            }

            // 缩减增量
            k = k / 3;
        }

        return a;
    }
}
