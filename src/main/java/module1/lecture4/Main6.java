package module1.lecture4;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your first number:");
        double a = scanner.nextDouble();
        System.out.println("Write your second number:");
        double b = scanner.nextDouble();
        System.out.println("Write your math operation:");
        String operation = scanner.next();

        double result = 0;

        if ("+".equals(operation)) {
            result = a + b;
        } else if ("-".equals(operation)) {
            result = a - b;
        } else if ("*".equals(operation)) {
            result = a * b;
        } else if ("/".equals(operation)) {
            result = a / b;
        } else if ("%".equals(operation)) {
            result = a % b;
        } else {
            System.out.println("Unsupported operation: " + operation);
        }

        System.out.println("First number: " + a + " Second number: " + b + " Result: " + result);
    }
}
