package module1.lecture7;

import java.util.Arrays;
import java.util.Random;

public class Main9 {
    /*

    Зчитує з консолі ціле число N.
    Якщо зчитане число N більше 0, то далі програма зчитує цілі числа, кількість яких дорівнює N.
    Вивести в консоль зчитані числа: якщо N непарне — в порядку введення, якщо парне — в зворотному порядку.

Кожне число виводити з нового рядка. Число N виводити не потрібно.
     */

    public static void main(String[] args) {
        Random random = new Random();
        int numbersCount = random.nextInt(10);

        if (numbersCount > 0) {
            int[] numbers = new int[numbersCount];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(100);
            }

            System.out.println("User numbers count: " + numbersCount);
            System.out.println("User numbers: " + Arrays.toString(numbers));
            if (numbersCount % 2 == 0) {
                System.out.println("Reverse order:");
                for (int i = numbers.length - 1; i >= 0 ; i--) {
                    System.out.print(numbers[i] + " ");
                }
            } else {
                System.out.println("Direct order:");
                for (int i = 0; i < numbers.length ; i++) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
