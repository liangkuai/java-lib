package string.sort.msd;

/**
 * 高位优先的字符串排序，升序
 * MSD（Most significant digital）
 *
 * @author liukai
 * @date 18-9-21
 */
public class MSDSort {

    private final int critical = 15;
    private String[] temp;

    public void sort(String[] a) {
        temp = new String[a.length];
        sort(a, 0, a.length - 1, 0);
    }

    private void sort(String[] a, int start, int end, int digit) {

        if (start >= end) {
            return;
        }

        // 小型子数组进行插入排序
        if (end - start <= critical) {
            for (int i = start + 1; i <= end - start; i++) {
                int j = i;
                String t = a[j];
                while ( (j > start) && (t.compareTo(a[j - 1]) < 0) ) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = t;
            }
            return;
        }

        int[] bucket = new int[256];
        boolean flag = true;

        for (int i = start; i <= end; i++) {
            if (digit >= a[i].length()) {
                bucket[0]++;
            } else {
                bucket[a[i].charAt(digit)]++;
                flag = false;
            }
        }

        if (flag)
            return;

        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = end; i >= start; i--) {
            if (digit >= a[i].length()) {
                temp[bucket[0]-- - 1] = a[i];
            } else {
                temp[bucket[a[i].charAt(digit)]-- - 1] = a[i];
            }
        }

        for (int i = start; i <= end; i++) {
            a[i] = temp[i - start];
        }

        for (int i = 0; i < bucket.length; i++) {
            if (i != bucket.length - 1)
                sort(a, start + bucket[i], start + bucket[i + 1] - 1, digit + 1);
            else
                sort(a, start + bucket[i], end, digit + 1);
        }
    }

}
