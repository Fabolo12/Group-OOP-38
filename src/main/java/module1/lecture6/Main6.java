package module1.lecture6;

public class Main6 {
    public static void main(String[] args) {
        int n1 = 0;
        System.out.println("Loop 1");
        do {
            System.out.println(n1--);
        } while (n1 > 0);

        int n2 = 0;
        System.out.println("Loop 2");
        while (n2 > 0) {
            System.out.println(n2--);
        }
    }
}
