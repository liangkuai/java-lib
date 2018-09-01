package heap.binary;


/**
 * @author liangkuai
 * @date 2018/9/1
 */
public class BinaryHeapTest {

    public static void main(String[] args) {
        Integer[] a = {49, 38, 65, 97, 76, 13, 27, 49};

        BinaryHeap<Integer> s = new BinaryHeap<>(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(s.deleteTop());
        }
    }

}