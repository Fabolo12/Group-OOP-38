package module1.lecture6;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = null;
        do {
            System.out.println("Write your number, or 'exit':");

            if (scanner.hasNextInt()) {
                int userInputNumber = scanner.nextInt();
                if (userInputNumber % 2 == 0) {
                    System.out.println("Number is even");
                } else {
                    System.out.println("Number is odd");
                }
            } else {
                userInput = scanner.nextLine();
            }
        } while (!"exit".equalsIgnoreCase(userInput));
    }
}
