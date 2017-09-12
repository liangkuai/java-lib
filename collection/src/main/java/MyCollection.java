import java.util.Iterator;

public interface MyCollection<E> extends Iterator<E> {

    int size();

    boolean isEmpty();

    boolean contains();

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(MyCollection<?> c);

    boolean addAll(MyCollection<? extends E> c);

    boolean removeAll(MyCollection<?> c);

    boolean retainAll(MyCollection<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();
}
