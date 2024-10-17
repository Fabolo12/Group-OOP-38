package module1.lecture7;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        int[][][] numbers3 = new int[2][3][6];
        int[][] numbers2 = new int[5][6];
        int[] numbers1 = new int[2];

        numbers1[0] = 1;
        numbers2[0][1] = 1;
        numbers3[0][1][2] = 1;

        System.out.println("numbers1: " + Arrays.toString(numbers1));
        System.out.println("numbers2: " + Arrays.deepToString(numbers2));
        System.out.println("numbers3: " + Arrays.deepToString(numbers3));

        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                System.out.print(numbers2[i][j] + " ");
            }
            System.out.println();
        }

        int[][] numbers4 = new int[3][];
        numbers4[0] = new int[10];
        numbers4[1] = new int[3];
        numbers4[2] = new int[7];
        System.out.println("numbers4: " + Arrays.deepToString(numbers4));

        for (int i = 0; i < numbers4.length; i++) {
            int[] ints = numbers4[i];
            for (int j = 0; j < numbers4[i].length; j++) {
                System.out.print(numbers4[i][j] + " ");
            }
            System.out.println();
        }
    }
}
