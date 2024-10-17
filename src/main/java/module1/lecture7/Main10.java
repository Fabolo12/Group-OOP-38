package module1.lecture7;

import java.util.Arrays;
import java.util.Random;

public class Main10 {
    /*
    У класі Solution дано двовимірний масив цілих чисел (поле array) розмірністю 3х3.
    У методі main потрібно заповнити порядково цей масив даними з клавіатури, порахувати
    суму елементів у кожному стовпці та у кожному рядку і вивести найменшу із цих сум на екран.
     */

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        final Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Matrix: " + Arrays.deepToString(matrix));

        int[] sumRows = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j]; // 0,0 0,1 0,2 1,0 1,1 1,2 2,0 2,1 2,2
            }
            sumRows[i] = sum;
        }
        System.out.println("Sum rows: " + Arrays.toString(sumRows));
        Arrays.sort(sumRows);
        System.out.println("Min sum rows: " + sumRows[0]);


        int[] sumColumns = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[j][i]; // 0,0 1,0 2,0 0,1 1,1 2,1 0,2 1,2 2,2
            }
            sumColumns[i] = sum;
        }

        System.out.println("Sum columns: " + Arrays.toString(sumColumns));
        Arrays.sort(sumColumns);
        System.out.println("Min sum rows: " + sumColumns[0]);
    }
}
