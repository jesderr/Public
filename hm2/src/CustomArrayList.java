import java.util.Collection;
import java.util.Comparator;

public interface CustomArrayList<E> {
    void add(E element);
    void add(int index, E element);
    void addAll(Collection<? extends E> collection);
    void clear();
    E get(int index);
    boolean isEmpty();
    E remove(int index);
    boolean remove(Object o);
    void sort(Comparator<? super E> comparator);
    int size();
    boolean contains(Object o);



}
