package module1.lecture3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your first line:");
        String line1 = scanner.nextLine();
        System.out.println("Write your second line:");
        String line2 = scanner.nextLine();
        System.out.println("Write your third line:");
        String line3 = scanner.nextLine();

        System.out.println("Line 3: " + line3);
        System.out.println("Line 2: " + line2.toUpperCase());
        System.out.println("Line 1: " + line1.toLowerCase());
    }
}
