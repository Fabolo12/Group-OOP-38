package module1.lecture4;

public class Main3 {
    public static void main(String[] args) {
        int a = 5;

        System.out.println("> " + (a > 5));
        System.out.println("< " + (a < 5));
        System.out.println(">= " + (a >= 5));
        System.out.println("<= " + (a <= 5));
        System.out.println("== " + (a == 5));
        System.out.println("!= " + (a != 5));


        System.out.println("true && true = " + (true && true)); // true
        System.out.println("true && false = " + (true && false)); // false
        System.out.println("false && true = " + (false && true)); // false
        System.out.println("false && false = " + (false && false)); // false

        System.out.println("true || true = " + (true || true)); // true
        System.out.println("true || false = " + (true || false)); // true
        System.out.println("false || true = " + (false || true)); // true
        System.out.println("false || false = " + (false || false)); // false

        System.out.println("!true = " + (!true)); // false
        System.out.println("!false = " + (!false)); // true
    }
}
