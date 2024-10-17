package module1.lecture6;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("Loop 1");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("Loop 2");
        for (int i = 0; i < 10; i += 2) { // i = i + 2
            System.out.println(i);
        }

        System.out.println("Loop 3");
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                System.out.println("Skip 3");
                continue;
            }
            System.out.println(i);
            if (i == 7) {
                break;
            }
        }

        System.out.println("Loop 4");
        int b = 0;
        for (; b < 2; b++) {
            System.out.println(b);
        }

        System.out.println("Loop 5");
        for (int i = 0; ; i++) {
            System.out.println(i);
            if (i == 2) {
                break;
            }
        }

        System.out.println("Loop 6");
        for (int i = 0; i < 2; ) {
            System.out.println(i++);
        }

        System.out.println("Loop 7");
        for (; ; ) {
            System.out.println("Infinity loop");
            break;
        }

        System.out.println("Loop 8");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}
