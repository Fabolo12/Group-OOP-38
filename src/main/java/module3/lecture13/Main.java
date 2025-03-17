package module3.lecture13;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String line1 = "Hello";
        String line2 = "Hello";
        String line3 = new String("Hello");

        System.out.println(line1 == line2); // true
        System.out.println(line1 == line3); // false
        final String intern = line3.intern();
        System.out.println(line1 == intern);

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false


    }
}
