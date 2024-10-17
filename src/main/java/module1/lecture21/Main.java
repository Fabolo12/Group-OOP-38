package module1.lecture21;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        printDate(new Object());
    }

    private static void printDate(Object o) {
        method1(o);
    }

    private static void method1(Object o) {
        method2(o);
    }

    private static void method2(Object o) {
        method3(o);
    }

    private static void method3(Object o) {
        Optional.of(o);
    }

    static class MyException extends Exception {
        public MyException(final String message) {
            super(message);
        }
    }
}
