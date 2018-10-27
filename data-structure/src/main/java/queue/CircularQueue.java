package queue;

/**
 * 循环队列（数组）
 *
 * 存储结构：数组
 * 实现方式：计数器
 *
 * @author liangkuai
 * @date 2018/10/27
 */
public class CircularQueue {

    private int[] data;
    private int font;

    /**
     * 指向队列最后一个元素
     */
    private int rear;

    /**
     * 队列实际元素数量
     */
    private int count;


    public CircularQueue(int k) {
        data = new int[k];
        font = 0;
        rear = k - 1;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        rear = (++rear == data.length) ? 0 : rear;
        data[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        font = (++font == data.length) ? 0 : font;
        count--;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return data[font];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

}
