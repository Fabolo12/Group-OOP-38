package module1.lecture4;

import java.util.Scanner;

public class Main {

    //        byte
//        short
//        int
//        long
//        char
//        float
//        double
//        boolean result = operation.equals("+");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your first number:");
        final int a = scanner.nextInt();
        System.out.println("Write your second number:");
        final int b = scanner.nextInt();
        System.out.println("Write your math operation:");
        final String operation = scanner.next();

        if (operation.equals("+")) {
            int result = a + b;
            System.out.println("Result: " + result);
            System.out.println("First number: " + a + " Second number: " + b + " Result: " + result);
        } else {
            System.out.println("Unsupported operation: " + operation);
        }
    }
}
