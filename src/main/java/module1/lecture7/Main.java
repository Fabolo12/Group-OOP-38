package module1.lecture7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 0;
        int[] arrayOfNumbers = new int[10];
        String[] arrayOfStrings = new String[5];
        String[] arrayOfStrings2 = new String[1];
        String[] arrayOfStrings3 = new String[0];
        String[] arrayOfStrings4 = new String[1];
        Scanner[] scanners = new Scanner[5];

        int[] arrayOfNumbers2;

        int arraySize = new Scanner(System.in).nextInt();
        arrayOfNumbers2 = new int[arraySize];
        System.out.println("Array size: " + arrayOfNumbers2.length);

        byte[] byteArray = new byte[2];
        short[] shortArray = new short[2];
        int[] intArray = new int[2];
        long[] longArray = new long[2];
        float[] floatArray = new float[2];
        double[] doubleArray = new double[2];
        char[] charArray = new char[2];
        boolean[] booleanArray = new boolean[2];
        String[] stringArray = new String[2];
        System.out.println("byteArray: " + Arrays.toString(byteArray));
        System.out.println("shortArray: " + Arrays.toString(shortArray));
        System.out.println("intArray: " + Arrays.toString(intArray));
        System.out.println("longArray: " + Arrays.toString(longArray));
        System.out.println("floatArray: " + Arrays.toString(floatArray));
        System.out.println("doubleArray: " + Arrays.toString(doubleArray));
        System.out.println("charArray: " + Arrays.toString(charArray));
        System.out.println("booleanArray: " + Arrays.toString(booleanArray));
        System.out.println("stringArray: " + Arrays.toString(stringArray));

    }
}
