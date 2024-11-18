package module2.lecture6;

import java.util.Random;

public class MyClass implements MyInterface {

    private static final Random RANDOM = new Random();

    private final int value;

    public MyClass() {
        this.value = RANDOM.nextInt(1000);
    }

    @Override
    public int print() {
        System.out.println("Hello World");
        return 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                '}';
    }
}
