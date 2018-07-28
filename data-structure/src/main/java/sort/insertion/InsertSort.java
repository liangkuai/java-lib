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
            int valueOfI = origin[i];

            int j = i;
            while ((j > 0) && (valueOfI < origin[j - 1])) {
                origin[j] = origin[j - 1];
                --j;
            }
            origin[j] = valueOfI;
        }

        return origin;
    }
}
