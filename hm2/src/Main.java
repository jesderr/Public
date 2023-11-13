import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> listOfIntegers = new MyArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(0);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(5);



        Comparator<Integer> comparator = Comparator.naturalOrder();

        listOfIntegers.sort(comparator);

        listOfIntegers.print();
    }
}