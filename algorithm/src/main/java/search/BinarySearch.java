package search;

/**
 * 二分查找，升序
 *
 * @author liukai
 * @date 2020-05-03
 */
public class BinarySearch {

    public int search(int[] a, int target) {
        int start = 0, end = a.length, mid;

        while (start < end) {
            mid = start + (end - start) / 2;

            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                start = mid + 1;
            else if (a[mid] > target)
                end = mid;
        }
        return -1;
    }

}
