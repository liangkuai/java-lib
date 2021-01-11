package sort.swap;

/**
 * 快速排序，升序
 *
 * @author liangkuai
 * @date 2018/7/31
 */
public class QuickSort {

    public static int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 递归
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private static void sort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivotIndex = partition(nums, left, right);
        sort(nums, left, pivotIndex - 1);
        sort(nums, pivotIndex + 1, right);
    }

    /**
     * 分区，快慢指针
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        // i：慢指针，j：快指针
        int i = left;

        // 分区:
        // [left + 1, i] < pivot
        // [i + 1, j] >= pivot
        for (int j = left + 1; j <= right; j++) {
            if (nums[j] < pivot) {
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;

        return i;
    }

    /**
     * 分区，对撞双指针
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private static int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;

        // 分区:
        // [left + 1, i) <= pivot
        // (j, right] >= pivot
        while (true) {
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            while (j > left && nums[j] > pivot) {
                j--;
            }

            if (i >= j)
                break;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        nums[left] = nums[j];
        nums[j] = pivot;

        return j;
    }
}
