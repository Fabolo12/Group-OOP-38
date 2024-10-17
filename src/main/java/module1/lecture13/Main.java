package module1.lecture13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Box box1 = new Box();
        final Box box2 = new Box(1);
        final Box box22 = new Box(1);
        final Box box222 = new Box(1);
        final Box box3 = new Box(1, 2);
        final Box box4 = new Box(1, 2, 3);

    /*    System.out.println(box2.equals(box22));
        System.out.println(box22.equals(box222));
        System.out.println(box2.equals(box222));
        System.out.println(box2.equals(""));

        System.out.println(box2.hashCode());
        System.out.println(box22.hashCode());
        System.out.println(box2.hashCode() == box22.hashCode());


        System.out.println(box2.hashCode() == box3.hashCode());*/


        if (box2.hashCode() == box22.hashCode()) {
            System.out.println("Maybe equal?");
            if (box2.equals(box22)) {
                System.out.println("Equal");
            } else {
                System.out.println("Not equal, collision");
            }
        } else {
            System.out.println("Not equal");
        }
    }
}
