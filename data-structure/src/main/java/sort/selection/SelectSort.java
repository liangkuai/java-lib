package sort.selection;

/**
 * 选择排序，升序
 *
 * @author liangkuai
 * @date 2018/7/23
 */
public class SelectSort {

    public int[] sort(int[] a) {

        // 外循环
        // 交换选择出来的最小元素
        for (int i = 0; i < a.length; ++i) {

            // 内循环
            // 查找最小元素下标
            int minIndex = i;
            for (int j = i; j < a.length; ++j) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }

            // 交换
            // 如果当前选择出来的最小元素已经在需要交换的位置上，就跳过
            if (minIndex != i) {
                int temp;
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }
}
