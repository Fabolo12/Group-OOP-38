package module1.lecture10;

public class Main {
    private static final double MATH_PI = 3.14;

    public final int a = 5;

    public static void main(String[] args) {
        final int a = 5;
//        a = 10; ERROR

        final int b;

        b = 10;
//        b = 11; ERROR

        final int[] arra = new int[5];
//        arra = new int[10]; ERROR
        arra[0] = 10;

        print(10);
    }

    private static void print(final int a) {
        System.out.println(a);
        int b = 50;
        System.out.println(a);
        System.out.println(b);
    }
}
