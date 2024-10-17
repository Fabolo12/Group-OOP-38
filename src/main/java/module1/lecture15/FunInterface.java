package module1.lecture15;

@FunctionalInterface
public interface FunInterface {
    void one();

    default void two() {

    }

    static void three() {

    }

    String toString();
}
