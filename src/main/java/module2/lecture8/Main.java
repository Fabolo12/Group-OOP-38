package module2.lecture8;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        method1(false);
        final int i = method2(false);
        System.out.println(i + i);
        final Object o = method3(false);
        System.out.println(o.toString());
        final List<Object> objects = method4(false);
        System.out.println(objects.size());
        objects.stream()
                .map(Object::toString)
                .forEach(System.out::println);
        System.out.println("-----");
        method1(true);
        final int i1 = method2(true);
        System.out.println(i1 + i1);
        final Object o1 = method3(true);
        if (o1 != null) {
            System.out.println(o1.toString());
        } else {
            System.out.println("null");
        }
        final List<Object> objects1 = method4(true);
        System.out.println(objects1.size());
        objects1.stream()
                .map(Object::toString)
                .forEach(System.out::println);

        final Object o2 = Objects.requireNonNullElse(o1, new Object());
        System.out.println(o2.toString());
    }

    private static void method1(final boolean exit) {
        if (exit) {
            return;
        }
        System.out.println("method1");
    }

    private static int method2(final boolean exit) {
        if (exit) {
            return -1;
        }
        System.out.println("method2");
        return 0;
    }

    private static Object method3(final boolean exit) {
        if (exit) {
            return null;
        }
        System.out.println("method3");
        return new Object();
    }

    private static List<Object> method4(final boolean exit) {
        if (exit) {
            return Collections.emptyList();
        }
        System.out.println("method4");
        return List.of(new Object());
    }
}
