package module1.lecture6;

public class Main2 {
    public static void main(String[] args) {
        int n1 = 5;
        System.out.println("Loop 1");
        while (n1 > 0) {
            System.out.println(n1--);
        }

        System.out.println();

        int n2 = 5;
        System.out.println("Loop 2");
        while (true) {
            System.out.println(n2--);
            if (n2 == 0) {
                break;
            }
        }

        System.out.println();

        int n3 = 5;
        System.out.println("Loop 3");
        while (n3 > 0) {
            if (n3 == 3) {
                n3--;
                System.out.println("Skip 3");
                continue;
            }

            System.out.println(n3--);
        }

        System.out.println("Finish");
    }
}
