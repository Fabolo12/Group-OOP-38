package module1.lecture7;

import java.util.Arrays;

public class Main7 {

    public static void main(String[] args) {
        int[] numbers = new int[2];
        numbers[0] = 1;
        numbers[1] = 2;

        int[] numbers2 = new int[5];
        numbers2[2] = 2;

        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        printArray("numbers2: ", numbers2);

        final int[] ints = Arrays.copyOf(numbers, numbers.length * 2);
        String line = "ints: ";
        printArray(line, ints);

        for (int i = 0; i < ints.length; i++) {
            ints[i] = 100;
        }
        printArray(line, ints);

        Arrays.fill(ints, 150);
        for (int i = 0; i < 2; i++) {
            printArray(line, ints);
        }
    }

    private static void printArray(String line, int[] array) {
        System.out.println("Method: " + line + Arrays.toString(array));
    }
}
