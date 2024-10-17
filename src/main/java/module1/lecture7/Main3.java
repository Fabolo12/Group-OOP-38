package module1.lecture7;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        int[] numbers = new int[2];
        numbers[0] = 1;

        int[] numbers2 = numbers;
        numbers2[0] = 2;

        System.out.println("numbers[0]: " + numbers[0]);

        int[] numbers3 = new int[2];
        numbers3[0] = numbers2[0] + 1; // numbers3[0] = 3 = numbers2[0] (2) + 1
        System.out.println("numbers[0]: " + numbers[0]);
        System.out.println("numbers2[0]: " + numbers2[0]);
        System.out.println("numbers3[0]: " + numbers3[0]);
    }
}
