package module2.lecture7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = -5; i < 5; i++) {
            numbers.add(i);
            numbers.add(i);
        }
//        filter(numbers);
//        distinct(numbers);
//        distinctObject();
//        sorted(numbers);
//        peek(numbers);
//        limit(numbers);
//        map(numbers);
//        mapFlat();
//        intStream();
//        collectorToList();
//        collectorToMap();
        collectorToJoin();
    }

    private static void collectorToJoin() {
        final List<String> strings = List.of("Hello", "World", "!");
        final StringBuilder stringBuilder = new StringBuilder();
        strings.forEach(word -> stringBuilder.append(word).append(", "));
        final String substring = stringBuilder.substring(0, stringBuilder.length() - 2);
        System.out.println(substring);


        final String joinedString = strings.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedString);

        final String joinedString2 = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joinedString2);

        final String joinedString3 = strings.stream()
                .collect(Collectors.joining());
        System.out.println(joinedString3);

        final String join = String.join(", ", strings);
        System.out.println(join);
    }

    private static void collectorToMap() {
        Map<Integer, String> map1 = Stream.of(1, 1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        x -> "*",
                        (x, y) -> x
                ));
        System.out.println(map1);
    }

    private static void collectorToList() {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        final List<Integer> evenNumbers = numbers.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println(evenNumbers);

        final List<Integer> evenNumbers2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers2);
    }

    private static void intStream() {
        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        final IntStream intStream = integerStream.mapToInt(Integer::intValue);
        final IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        System.out.println(intSummaryStatistics);

        final int[] sum = new int[1];
        Stream.of(1, 2, 3, 4, 5)
                .forEach(x -> sum[0] += x);
        System.out.println(sum[0]);

        final AtomicInteger sum2 = new AtomicInteger();
        Stream.of(1, 2, 3, 4, 5)
                .forEach(sum2::addAndGet);
        System.out.println(sum2.get());
    }

    private static void mapFlat() {
        final List<Box> boxes = List.of(new Box(1), new Box(1), new Box(2), new Box(2));
        boxes.stream()
                .map(box -> box.presents)
                .forEach(System.out::println);

        boxes.stream()
                .flatMap(box -> box.presents.stream())
                .forEach(System.out::println);
    }

    private static void map(final List<Integer> numbers) {
        numbers.stream()
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                .peek(System.out::println)
                .map(x -> "***" + x + "***")
                .map(x -> "[" + x + "]")
                .forEach(System.out::println);
    }

    private static void limit(final List<Integer> numbers) {
        numbers.stream()
                .skip(7)
                .filter(x -> x > 0)
                .limit(3)
                .forEach(System.out::println);
    }

    private static void peek(final List<Integer> numbers) {
        numbers.stream()
                .peek(System.out::println)
                .forEach(System.out::println);
    }

    private static void sorted(final List<Integer> numbers) {
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void distinctObject() {
        Stream.of(new Box(1), new Box(1), new Box(2), new Box(2))
                .distinct()
                .forEach(System.out::println);
    }

    private static void distinct(final List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void filter(final List<Integer> numbers) {
        final Predicate<Integer> isPositiveAndEvenPredicate = value -> value > 0 && value % 2 == 0;
        numbers.stream()
//                .filter(x -> x > 0)
                .filter(Main::isPositiveAndEven)
                .filter(isPositiveAndEvenPredicate)
                .forEach(System.out::println);
    }

    private static boolean isPositiveAndEven(final int value) {
        return value > 0 && value % 2 == 0;
    }

    private static void createStreams() {
        Stream.of("Hello", "World", "!").forEach(System.out::println);
        Stream.empty().forEach(System.out::println);
        Stream.concat(Stream.of("Hello", "World", "!"), Stream.of("Goodbye", "World", "!"))
                .forEach(System.out::println);
        Stream.iterate(0, value -> value + 1).limit(10).forEach(System.out::println);
        Stream.generate(() -> "Hello").limit(10).forEach(System.out::println);
        Arrays.stream(new int[]{1, 2, 3, 4, 5}).forEach(System.out::println);
    }

    static class Box {
        private final int value;

        private final List<Integer> presents = new ArrayList<>();

        public Box(final int value) {
            this.value = value;
            for (int i = 0; i < 3; i++) {
                presents.add(new Random().nextInt(100));
            }
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            final Box box = (Box) o;
            return value == box.value;
        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "value=" + value +
                    ", presents=" + presents +
                    '}';
        }
    }
}
