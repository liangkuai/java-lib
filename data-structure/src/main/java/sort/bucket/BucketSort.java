package sort.bucket;

/**
 * 桶排序，升序
 *
 * @author liukai
 * @date 18-9-20
 */
public class BucketSort {

    public int[] sort(int[] a, int max) {
        int[] bucket = new int[max];

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        for (int i = 0, j = 0; i < max; i++) {
            while (bucket[i]-- > 0) {
                a[j++] = i;
            }
        }

        return a;
    }

}
