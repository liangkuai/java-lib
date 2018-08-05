package sort.selection;

/**
 * 选择排序，升序
 *
 * @author liangkuai
 * @date 2018/7/23
 */
public class SelectSort {

    public int[] sort(int[] origin) {
        for (int i = 0; i < origin.length; ++i) {

            // 查找最小元素下标
            int minIndex = i;
            for (int j = i; j < origin.length; ++j) {
                if (origin[j] < origin[minIndex])
                    minIndex = j;
            }

            // 交换
            int temp;
            temp = origin[i];
            origin[i] = origin[minIndex];
            origin[minIndex] = temp;
        }
        return origin;
    }
}
