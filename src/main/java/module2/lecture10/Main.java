package module2.lecture10;

public class Main {
    public static void main(String[] args) {
        print1(0);
        print2(0);
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1); // 5 * 4 * 3 * 2 * 1
    }

    private static void print1(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i == 10) {
            return;
        }
        System.out.println("*".repeat(i));
        print1(i + 1);
    }

    private static void print2(int i) {
        if (i < 1) {
            i = 1;
        }
        for (int j = i; j < 10; j++) {
            System.out.println("*".repeat(j));
        }
    }
}
