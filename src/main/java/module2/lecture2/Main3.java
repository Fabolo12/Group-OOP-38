package module2.lecture2;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        printMessage(0, new String[]{});
        printMessage(0, new String[]{"Hello"});
        printMessage(0, new String[]{"Hello", "World"});
    }

    private static void printMessage(int numbers, String[] message) {
        String[] newMessage = message;
        System.out.println("Child: " + Arrays.toString(newMessage));
    }
}
