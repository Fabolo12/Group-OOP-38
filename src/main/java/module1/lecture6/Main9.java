package module1.lecture6;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write your math operation, if you want stop write 'exit':");
            String operation = scanner.next();
            if ("exit".equalsIgnoreCase(operation)) {
                System.out.println("Bye!");
                break;
            }

            System.out.println("Write your first number:");
            double a = scanner.nextDouble();
            System.out.println("Write your second number:");
            double b = scanner.nextDouble();

            double result = 0;

            switch (operation) {
                case "+": {
                    result = a + b;
                    break;
                }
                case "-": {
                    result = a - b;
                    break;
                }
                case "*": {
                    result = a * b;
                    break;
                }
                case "/": {
                    result = a / b;
                    break;
                }
                case "%": {
                    result = a % b;
                    break;
                }
                default: {
                    System.out.println("Unsupported operation: " + operation);
                }
            }

            System.out.println("First number: " + a + " Second number: " + b + " Result: " + result);
        }
    }
}
