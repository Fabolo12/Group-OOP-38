package module1.lecture7;

import java.util.Arrays;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[3] = 3;
        System.out.println(Arrays.toString(numbers));

        System.out.println("Index 0: " + numbers[0]);
        System.out.println("Index 1: " + numbers[1]);
        System.out.println("Index 2: " + numbers[2]);
        System.out.println("Index 3: " + numbers[3]);
        System.out.println("Index 4: " + numbers[4]);

        numbers[0] = 5;
        System.out.println("Size: " + numbers.length); // size 5, last index 4
        final Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // sum = sum + numbers[i];
        }
        System.out.println("Sum: " + sum);
    }

}
