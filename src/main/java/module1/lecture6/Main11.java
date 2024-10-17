package module1.lecture6;

import java.util.Scanner;

public class Main11 {
    /*
    Приклад уведення:
8
4 // мінімальне число
7
4 // мінімальне число
5 // друге за величиною число (друге мінімальне)
9
5 // друге за величиною число (друге мінімальне)
exit

Приклад виведення:
5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your 2 numbers, or something to exit:");

        int min = scanner.nextInt(); // 10
        int secondMin = scanner.nextInt(); // 5
        if (secondMin < min) {
            int temp = min; // 10
            min = secondMin; // 10 -> 5
            secondMin = temp; // 5 -> 10
        }

        System.out.println("Write your number, or something to exit:");
        while (scanner.hasNextInt()) {
            System.out.println("Write your number, or something to exit:");
            int userNumber = scanner.nextInt();
            if (userNumber < min) {
                min = userNumber;
            }
            if (userNumber > min && userNumber < secondMin) {
                secondMin = userNumber;
            }
        }

        System.out.println("Min value: " + min);
        System.out.println("Second min value: " + secondMin);
    }
}
