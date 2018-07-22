package search.binary;

/**
 * 二分查找，折半查找
 *
 * @author liangkuai
 * @date 2018/7/22
 */
public class BinarySearch {

    public int search(int[] origin, int key) {
        int i = 0;
        int j = origin.length - 1;

        while (i <= j) {

            int mid = (i + j) / 2;

            if (key > origin[mid])
                i = mid + 1;
            else if (key < origin[mid])
                j = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
