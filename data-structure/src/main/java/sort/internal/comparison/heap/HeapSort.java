package sort.internal.comparison.heap;

/**
 * 堆排序，升序
 *
 * @author liangkuai
 * @date 2018/8/7
 */
public class HeapSort {

    public int[] sort(int[] a) {

        // 升序排序，先构造最大堆
        for (int i = (a.length / 2); i > 0; --i) {
            sink(a, i, a.length);
        }

        // 循环输出堆顶到数组尾部，再调整堆
        for (int i = a.length - 1; i > 0; --i) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;

            sink(a, 1, i - 1);
        }

        return a;
    }

    /**
     * 下沉调整
     *
     * @param index 实际下沉元素在数组中下标 + 1
     */
    public void sink(int[] a, int index, int length) {
        int val = a[index - 1];

        for (int i = index * 2; i <= length; i *= 2) {
            // index 的两个子节点比较
            if ((i < length) && (a[i] > a[i - 1]))
                ++i;
            // index 与较大的子节点比较
            if (val > a[i - 1])
                break;
            // index 节点取较大子节点的值
            // 再让 index 指向被交换值得子节点，继续往下调整堆
            a[index - 1] = a[i - 1];
            index = i;
        }
        a[index - 1] = val;
    }
}
