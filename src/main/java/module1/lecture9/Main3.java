package module1.lecture9;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("number before method call = " + number);
        methodWithInt(number);
        System.out.println("number after method call = " + number);

        System.out.println("~".repeat(10));
        int[] numbers = {5};
        System.out.println("number before method call = " + Arrays.toString(numbers));
        methodWithIntArray(numbers);
        System.out.println("number after method call = " + Arrays.toString(numbers));

        System.out.println("~".repeat(10));
        String line = "Hello";
        System.out.println("number before method call = " + line);
        methodWithString(line);
        System.out.println("number after method call = " + line);

        System.out.println("~".repeat(10));
        StringBuilder builder = new StringBuilder("Hello");
        System.out.println("number before method call = " + builder);
        methodWithStringBuilder(builder);
        System.out.println("number after method call = " + builder);
    }

    private static void methodWithInt(int param) {
        System.out.println("param before change = " + param);
        param += 10;
        System.out.println("param after change = " + param);
    }

    private static void methodWithIntArray(int[] param) {
        System.out.println("param before change = " + Arrays.toString(param));
        param[0] = 10;
        System.out.println("param after change = " + Arrays.toString(param));
    }

    private static void methodWithString(String param) {
        System.out.println("param before change = " + param);
        param += " world";
        System.out.println("param after change = " + param);
    }

    private static void methodWithStringBuilder(StringBuilder param) {
        System.out.println("param before change = " + param);
        param.append(" world");
        System.out.println("param after change = " + param);
    }
}
