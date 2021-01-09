package sort.swap;

/**
 * 冒泡排序，升序
 *
 * @author liangkuai
 * @date 2018/8/4
 */
public class BubbleSort {

    public static int[] sort(int[] nums) {
        int len = nums.length, tmp;

        // nums.length - 1 次内循环
        for (int i = 1; i <= len - 1; i++) {
            // 冒泡
            for (int j = 0; j < len - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 优化：交互标识
     */
    public static int[] sort2(int[] nums) {
        int len = nums.length, tmp;

        // nums.length - 1 次内循环
        for (int i = 1; i <= len - 1; i++) {
            boolean change = false;

            // 冒泡
            for (int j = 0; j < len - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;

                    change = true;
                }
            }

            // 未发生交换表示整体有序，直接返回
            if (!change) {
                break;
            }
        }
        return nums;
    }
}