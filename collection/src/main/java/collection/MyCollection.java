package collection;

public interface MyCollection<E> {

    int size();

    boolean isEmpty();

    boolean contains();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(MyCollection<?> c);

    boolean addAll(MyCollection<? extends E> c);

    boolean removeAll(MyCollection<?> c);

    boolean retainAll(MyCollection<?> c);

    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
