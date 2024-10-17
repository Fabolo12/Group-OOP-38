package module1.lecture9;

import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = new int[arr.length];

        for (int i = arr.length - 1, y = 0; i >= 0; i--, y++) {
            newArr[y] = arr[i];
        }

        System.out.println("Original array:" + Arrays.toString(arr));
        System.out.println("Reversed array:" + Arrays.toString(newArr));
    }
}
