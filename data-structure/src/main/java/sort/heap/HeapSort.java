package sort.heap;

/**
 * 堆排序，升序
 *
 * @author liangkuai
 * @date 2018/8/7
 */
public class HeapSort {

    /**
     * 为了简化操作，便于理解；数组下标从 1 开始。
     */
    public int[] sort(int[] a) {

        // 升序排序，先构造最大堆
        for (int i = (a.length / 2); i > 0; --i) {
            adjust(a, i, a.length - 1);
        }

        // 循环输出堆顶到数组尾部，再调整堆
        for (int i = a.length - 1; i > 1; --i) {
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;

            adjust(a, 1, i - 1);
        }

        return a;
    }

    public void adjust(int[] a, int index, int len) {
        int val = a[index];
        int i;
        for (i = index * 2; i <= len; i *= 2) {
            // index 的两个子节点比较
            if ((i < len) && (a[i] < a[i + 1]))
                ++i;
            // index 与较大的子节点比较
            if (val > a[i])
                break;
            // index 节点取较大子节点的值
            // 再让 index 指向被交换值得子节点，继续往下调整堆
            a[index] = a[i];
            index = i;
        }
        a[index] = val;
    }
}
