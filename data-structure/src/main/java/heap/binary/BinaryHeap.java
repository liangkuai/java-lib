package heap.binary;

/**
 * 二叉堆，最大堆
 *
 * @author liangkuai
 * @date 2018/9/1
 */
public class BinaryHeap<K extends Comparable<K>> {

    private K[] a;

    /**
     * 堆中当前实际元素数量
     */
    private int count;

    public BinaryHeap(K[] a) {
        this.a = a;
        this.count = a.length;
        generateHeap();
    }


    /**
     * 生成堆
     */
    public void generateHeap() {
        for (int i = (a.length / 2); i > 0; --i) {
            sink(i);
        }
    }

    /**
     * 插入元素
     */
    public void put(K newNode) {
        a[++count] = newNode;
        swim(count);
    }


    /**
     * 删除堆顶元素
     */
    public K deleteTop() {
        K max = a[0];

        // 堆末尾元素移至堆顶
        a[0] = a[count - 1];
        a[count-- - 1] = null;

        // 下沉调整
        sink(1);

        return max;
    }


    /**
     * 上浮
     */
    private void swim(int swimIndex) {
        K swimValue = a[swimIndex - 1];

        // 确定上浮元素在数组中的下标
        for (int i = swimIndex / 2; i >= count; i /= 2) {
            // 当前上浮节点与较大的子节点比较
            if (swimValue.compareTo(a[i - 1]) > 0) {
                // 上浮元素大于父节点
                // 父节点值赋值给当前上浮元素所在下标，上浮元素取父节点下标，继续上浮调整
                a[swimIndex - 1] = a[i - 1];
                swimIndex = i;
            } else {
                // 上浮元素不大于父节点，结束上浮操作
                break;
            }
        }

        // 将上浮元素值赋值到最终位置
        a[swimIndex - 1] = swimValue;
    }


    /**
     * 下沉
     */
    private void sink(int sinkIndex) {
        K sinkValue = a[sinkIndex - 1];

        // 确定下沉元素在数组中的下标
        for (int i = sinkIndex * 2; i <= count; i *= 2) {
            // 当前下沉节点的两个子节点比较，i 指向较大子节点
            if (i < count && (a[i].compareTo(a[i - 1]) > 0)) {
                ++i;
            }

            // 当前下沉节点与较大的子节点比较
            // 如果还是下沉节点更大，结束下沉操作
            if (sinkValue.compareTo(a[i - 1]) > 0) {
                break;
            }

            // 较大子节点值赋值给当前下沉元素所在下标，下沉元素取较大子节点下标，继续下沉调整
            a[sinkIndex - 1] = a[i - 1];
            sinkIndex = i;
        }

        // 将下沉元素值赋值到最终位置
        a[sinkIndex - 1] = sinkValue;
    }
}
