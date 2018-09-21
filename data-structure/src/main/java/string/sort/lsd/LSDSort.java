package string.sort.lsd;

/**
 * 低位优先的字符串排序，升序
 * LSD（Least significant digital）
 *
 * @author liukai
 * @date 18-9-20
 */
public class LSDSort {

    public String[] sort(String[] a) {
        String[] temp = new String[a.length];

        // 从由向左，每个字符做桶排序
        for (int digit = a[0].length() - 1; digit >= 0; digit--) {
            int[] bucket = new int[256];

            // 统计
            for (int i = 0; i < a.length; i++) {
                bucket[a[i].charAt(digit)]++;
            }

            // 确定每个桶的位置
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            // 放置桶元素
            for (int i = a.length - 1; i >= 0; i--) {
                temp[bucket[a[i].charAt(digit)]-- - 1] = a[i];
            }

            // 复制
            for (int i = 0; i < a.length; i++) {
                a[i] = temp[i];
            }
        }

        return a;
    }
}
