package module1.lecture14;

import java.util.Random;

public class Main3 {

    public final static int CONSTANT = 5;

    public int notConstant;

    public static void main(String[] args) {
        Box.numberStatic = 15;
        System.out.println("BoxObject 1: " + Box.numberStatic);
        System.out.println("BoxObject 2: " + Box.numberStatic);
        Box.numberStatic = 25;
        System.out.println("BoxObject 1: " + Box.numberStatic);
        System.out.println("BoxObject 2: " + Box.numberStatic);

        Box.printStatic();

        System.out.println(Math.abs(-5));
        final Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println(Math.random()  * 100);
    }
}

class Box {
    int number;
    static int numberStatic;

    public void print() {
        System.out.println("Number: " + number);
        System.out.println(numberStatic);
    }

    public static void printStatic() {
        System.out.println("Number: " + numberStatic);
    }
}