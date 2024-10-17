package module1.lecture7;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your 2 numbers, or something to exit:");

        int[] numbers = new int[3];
        Arrays.fill(numbers, Integer.MAX_VALUE);

        numbers[0] = scanner.nextInt();
        numbers[1] = scanner.nextInt();

        for (int i = 2; i < numbers.length; i++) {
            System.out.println("Write your number, or something to exit:");
            final String line = scanner.next();
            if (line.equals("exit")) {
                break;
            }
            numbers[i] = Integer.parseInt(line);

            if (i == numbers.length - 1) {
                System.out.println("Increase array size");
                int oldLength = numbers.length;
                numbers = Arrays.copyOf(numbers, numbers.length * 2);
                Arrays.fill(numbers, oldLength, numbers.length, Integer.MAX_VALUE);
            }
        }

        System.out.println("All numbers: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("All sort numbers: " + Arrays.toString(numbers));
        System.out.println("Min value: " + numbers[0]);
        System.out.println("Second min value: " + numbers[1]);

        for (int i = 1; i < numbers.length; i++) {
            final int nextNumber = numbers[i];
            if (nextNumber != numbers[0]) {
                System.out.println("Second min value: " + nextNumber);
                break;
            }
        }
    }
}
