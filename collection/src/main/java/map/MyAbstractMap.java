package map;

public abstract class MyAbstractMap<K, V> implements MyMap<K, V> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
