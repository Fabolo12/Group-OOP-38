package module1.lecture15;

import java.util.Scanner;

public class Box {

    private final Scanner scanner;

    private int width;

    public Box(final Scanner scanner, final int width) {
        this.scanner = scanner;
        this.width = width;
    }

    public void getInfoFromUser() {
        final String line = scanner.nextLine();
        System.out.println("You entered: " + line);
    }

    public int getWidth() {
        return width;
    }
}

record Box2(Scanner scanner, int width) {

    public void getInfoFromUser() {
        final String line = scanner.nextLine();
        System.out.println("You entered: " + line);
    }
}

class Main {
    public static void main(String[] args) {
        final Box box = new Box(null, 10);
        System.out.println(box.getWidth());

        final Box2 box2 = new Box2(null, 10);
        System.out.println(box2.width());
    }
}