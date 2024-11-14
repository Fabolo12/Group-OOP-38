package module2.lecture5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wildcards {
    public static void main(String[] args) {
        print("Hello");
        print(1);

        final List<String> strings = List.of("Hello", "World");
        final List<Integer> integers = List.of(1, 2, 3);
        print(strings);
        print(integers);

        printList(strings);
        printList(integers);

        printList2(strings);
        printList2(integers);

//        printList3(strings);
        printList3(integers);
        final List<Double> doubles = List.of(1.0, 2.0, 3.0);
        printList3(doubles);
//        final List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(1.2);
//        numbers.add(null);

        final List<Number> numbers = List.of(1.0, 2.0, 3.0);
        printList4(numbers);

        final List<? super Number> values = new ArrayList<>();
        values.add(1);
        values.add(1.0);
    }

    private static <T> void print(T value) {
        System.out.println(value);
    }

    private static <T extends List> void printList(T values) {
        System.out.println(values);
    }

    private static void printList2(List<?> values) {
        System.out.println(values);
    }

    private static void printList3(List<? extends Number> values) {
        System.out.println(values);
        final Number first = values.getFirst();
        System.out.println(first);
    }

    private static <T extends Number> void printList5(List<T> values) {
        System.out.println(values);
    }

    private static void printList4(List<? super Number> values) {
        System.out.println(values);
        final Object first = values.getFirst();
    }
}
