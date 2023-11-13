import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Arrays.compare;

public class Sorter<E> {

    public static <E> void sortCollection(E[] a, int size, Comparator<? super E> c) {
        mergeSort(a, 0, size - 1, c);
    }

    private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> c) {
        if (from == to)
            return;
        int mid = (from + to) / 2;
        mergeSort(a, from, mid, c);
        mergeSort(a, mid + 1, to, c);
        merge(a, from, mid, to, c);
    }
    private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> c) {
        int n = to - from + 1;
        Object[] values = new Object[n];

        int fromValue = from;
        int middleValue = mid + 1;
        int index = 0;

        while (fromValue <= mid && middleValue <= to) {
            if (c.compare(a[fromValue], a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }

        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }

        for (index = 0; index < n; index++)
            a[from + index] = (E) values[index];
    }
}
