package module2.lecture6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    private static int delta = 1;

    public static void main(String[] args) {
//        createStandardClass();
//        createLongFormClass();
//        forEach();
//        returnInt();

        final int stringLength = 1;
        final Predicate<String> predicate = value -> value.length() == stringLength * delta;
        System.out.println(predicate.test("Hello"));
        delta = 5;
        System.out.println(predicate.test("Hello"));

        final List<MyClass> myClasses = new ArrayList<>(List.of(new MyClass(), new MyClass(), new MyClass()));
        myClasses.forEach(value -> {
            if (value.getValue() > 100) {
                System.out.println("return from lambda");
                return;
            }
            System.out.println(value);
        });

        for (MyClass value : myClasses) {
            if (value.getValue() > 100) {
                System.out.println("return from loop");
                continue;
            }
            System.out.println(value);
        }
        System.out.println("return from main");
    }

    private static void supplier() {
        final Supplier<MyClass> supplier = MyClass::new;
        final List<MyClass> myClasses = new ArrayList<>(List.of(supplier.get(), supplier.get(), supplier.get()));
        System.out.println(myClasses);
    }

    private static void function() {
        final List<MyClass> myClasses = new ArrayList<>(List.of(new MyClass(), new MyClass(), new MyClass()));
        final Function<MyClass, Integer> mapper = MyClass::getValue;
        myClasses.forEach(value -> System.out.println(mapper.apply(value)));
    }

    private static void consumer() {
        final List<MyClass> myClasses = new ArrayList<>(List.of(new MyClass(), new MyClass(), new MyClass()));
        final Consumer<MyClass> consumer = value -> System.out.println("Value is " + value);
        myClasses.forEach(consumer);
    }

    private static void predicate() {
        final List<MyClass> myClasses = new ArrayList<>(List.of(new MyClass(), new MyClass(), new MyClass()));
        final Predicate<MyClass> greaterThan500 = value -> value.getValue() > 500;
        final Predicate<MyClass> lessThan500 = value -> value.getValue() < 500;

        System.out.println(myClasses);
        myClasses.forEach(value -> {
            if (predicateMethod(lessThan500, value)) {
                System.out.println(value);
            } else {
                System.out.println("Value is less than 500 : " + value);
            }
        });
    }

    private static boolean predicateMethod(final Predicate<MyClass> predicate, final MyClass value) {
        return predicate.test(value);
    }

    private static void lambda() {
        final List<MyClass> myClasses = new ArrayList<>(List.of(new MyClass(), new MyClass(), new MyClass()));
        System.out.println(myClasses);
        Collections.sort(myClasses, new MyComparator());
        System.out.println(myClasses);
        Collections.sort(myClasses, new MyComparator().reversed());
        System.out.println(myClasses);


        Collections.sort(myClasses, new Comparator<MyClass>() {
            @Override
            public int compare(final MyClass o1, final MyClass o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(myClasses);
        Collections.sort(myClasses, (o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println(myClasses);
        Collections.sort(myClasses, Comparator.comparingInt(MyClass::getValue));
        System.out.println(myClasses);

        myClasses.forEach(c -> System.out.println("**" + c + "**"));
        myClasses.forEach(System.out::println);
    }

    private static void returnInt() {
        MyInterface myInterface = () -> {
            System.out.println("Hello World 2");
            return 0;
        };
        System.out.println(myInterface.print());

        MyInterface myInterface2 = () -> 0;
        System.out.println(myInterface2.print());
    }

    private static void forEach() {
        List<String> list = List.of("Hello", "World");
        for (String word : list) {
            System.out.println(word);
        }
        list.forEach(word -> System.out.println(word));

        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);
        map.forEach((key, value) -> System.out.println(key + " " + value));

        list.forEach(word -> {
            final String upperCase = word.toUpperCase();
            System.out.println(upperCase);
        });
    }

    private static void createLongFormClass() {
        final MyInterface myInterface = new MyInterface() {
            @Override
            public int print() {
                System.out.println("Hello World 2");
                return 0;
            }
        };

        myInterface.print();
    }

    private static void createStandardClass() {
        final MyInterface myInterface = new MyClass();
        myInterface.print();
    }
}
