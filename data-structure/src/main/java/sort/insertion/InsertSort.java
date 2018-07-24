package sort.insertion;

/**
 * 直接插入排序, 升序
 *
 * @author liangkuai
 * @date 2018/7/24
 */
public class InsertSort {

    public int[] sort(int[] origin) {

        for (int i = 1; i < origin.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (origin[j] < origin[j - 1]) {
                    // 交换
                    int temp = origin[j - 1];
                    origin[j - 1] = origin[j];
                    origin[j] = temp;
                } else {
                    break;
                }
            }
        }

        return origin;
    }
}
