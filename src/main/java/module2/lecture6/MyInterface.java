package module2.lecture6;

@FunctionalInterface
public interface MyInterface {
    int print();

    static void print2() {
        System.out.println("Hello World");
    }

    default void print3() {
        System.out.println("Hello World");
    }
}
