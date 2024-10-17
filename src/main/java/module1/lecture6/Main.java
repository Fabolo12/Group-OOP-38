package module1.lecture6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write your number, or 'exit':");
            String userInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userInput)) {
                System.out.println("Bye!");
                break;
            }

            if (Integer.parseInt(userInput) % 2 == 0) {
                System.out.println("Number is even");
            } else {
                System.out.println("Number is odd");
            }
        }
    }
}
