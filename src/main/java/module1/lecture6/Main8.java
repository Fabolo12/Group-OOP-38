package module1.lecture6;

import java.util.Random;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        final int randomNumber = random.nextInt(0, 100);

        System.out.println("Count attempts to guess the number from 0 to 100");
        int attempts = scanner.nextInt();

        for (int i = 0; i < attempts; i++) {
            System.out.println("Write your number:");
            int userTry = scanner.nextInt();

            if (userTry == randomNumber) {
                System.out.println("Congratulations! You guessed the number!");
            } else {
                String result = userTry > randomNumber
                        ? "Your number is greater than the number" : "Your number is less than the number";
                System.out.println(result);
            }
        }
        System.out.println("The number was: " + randomNumber);
    }
}
