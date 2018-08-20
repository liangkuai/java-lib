package sort.insertion;

/**
 * 直接插入排序, 升序
 *
 * @author liangkuai
 * @date 2018/7/24
 */
public class InsertSort {

    public int[] sort(int[] a) {

        for (int i = 1; i < a.length; ++i) {

            // 待排元素的值
            int valueOfI = a[i];

            // 内循环中当前比较元素的下标
            int j = i;

            // 内循环
            // 对有序部分，从后往前比较；
            // 若待排元素的值小于当前比较元素的值，则将当前元素后移。
            while ((j > 0) && (valueOfI < a[j - 1])) {
                a[j] = a[j - 1];
                --j;
            }

            // 确定待排元素的位置后，赋值。
            a[j] = valueOfI;
        }

        return a;
    }
}
