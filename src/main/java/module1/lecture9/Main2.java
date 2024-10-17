package module1.lecture9;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments");
        }
        if (args[0].equals("password")) {
            System.out.println("Password is correct");
        } else {
            System.out.println("Password is incorrect");
        }
        methodWithParams("Hello", 1);
        String line = "Hello";
        int number = 1;
        methodWithParams(line, number);
    }

    private static void methodWithParams(String param1, int param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }
}
