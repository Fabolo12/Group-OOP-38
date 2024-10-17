package module1.lecture9;

import java.util.Scanner;

public class Calc {

    private static String line = "-----------------------------------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a = scanner.nextInt();
        System.out.println("Enter second number:");
        int b = scanner.nextInt();
        System.out.println("Enter operation:");
        String operation = scanner.next();

        if ("+".equals(operation)) {
            sum(a, b);
        } else if ("-".equals(operation)) {
            sub(a, b);
        } else if ("*".equals(operation)) {
            mul(a, b);
        } else if ("/".equals(operation)) {
            div(a, b);
        } else {
            System.out.println("Unsupported operation: " + operation);
        }
        System.out.println(line);
    }

    private static void sum(int a, int b) {
        System.out.println("Sum: " + (a + b));
        System.out.println(line);
    }

    private static void sub(int a, int b) {
        System.out.println("Sub: " + (a - b));
        System.out.println(line);
    }

    private static void mul(int a, int b) {
        System.out.println("Mul: " + (a * b));
        System.out.println(line);
    }

    private static void div(int a, int b) {
        System.out.println("Div: " + (a / b));
        System.out.println(line);
    }
}
