/**
 * @author liangkuai
 * @date 2017/10/29
 */

public class TestAbstractCollection<E> {

    public MyIterator<E> iterator() {
        return new It();
    }

    private class It implements MyIterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }


}
