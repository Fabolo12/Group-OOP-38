package module1.lecture9;

public class Main6 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            if (i == 5) {
                break;
            }
        }
        System.out.println("Line after loop");

        System.out.println(div(10, 2));
        System.out.println(div(10, 0));
    }

    private static int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (a == 0) {
            return 0;
        }
        if (a < b) {
            return 0;
        }
        return a / b;
    }
}
