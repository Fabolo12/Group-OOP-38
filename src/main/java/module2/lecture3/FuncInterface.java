package module2.lecture3;

@FunctionalInterface
public interface FuncInterface {
    void method1();

    default void method2() {
        System.out.println("Method 2");
    }

    static void method3() {
        System.out.println("Method 3");
    }

    String toString();
}
