import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<E> implements CustomArrayList<E> {
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] array;
    private Sorter sorter;

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.array = new Object[capacity];
        this.sorter = new Sorter();
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new Object[capacity];
        this.sorter = new Sorter();
    }

    private void verificationCapacity() {
        if (size == capacity) {
            this.capacity = capacity + (capacity >> 1);
            Object[] array = new Object[this.capacity];
            System.arraycopy(this.array, 0, array, 0, size);
            this.array = array;
        }
    }

    @Override
    public void add(E element) {
        verificationCapacity();
        array[size++] = element;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Bad index");
        }
    }

    @Override
    public void add(int index, Object element) {
        verificationCapacity();
        if (index == size) {
            array[size++] = element;
            return;
        }
        checkIndex(index);
        if (index != size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }

    }

    public void trimToSize() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        this.size = size + collection.size();
        if (this.size > capacity) {
            verificationCapacity();
        }
        for (E element : collection) {
            array[size++] = element;
        }
    }

    @Override
    public void clear() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) array[index];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return (E) removeElementOnIndex(index);
    }


    private Object removeElementOnIndex(int index){
        array[index] = null;
        for (int i = index; i <= size; i++) {
            if( i == size -1 ){
                array[i] = null;
                break;
            }else{
                array[i] = array[i+1];
            }
        }
        array = Arrays.copyOf(array,size()-1);
        size--;
        return array;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                removeElementOnIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        sorter.sortCollection((E[])array, size, c);
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if(array[i] == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Array [" + i + "] = " + array[i]);
        }
        System.out.println("Capacity = " + capacity);
    }
}
