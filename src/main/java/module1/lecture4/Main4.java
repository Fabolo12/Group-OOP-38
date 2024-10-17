package module1.lecture4;

public class Main4 {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;

        boolean aEqualsB = a == b;
        boolean bEqualsC = b == c;

        if (aEqualsB && bEqualsC) {
            System.out.println("All the same");
        } else {
            System.out.println("Not all the same");
        }

        String result = aEqualsB && bEqualsC ? "All the same" : "Not all the same";
        System.out.println(result);
        System.out.println(aEqualsB && bEqualsC ? "All the same" : "Not all the same");
        System.out.println(a == b && b == c ? "All the same" : "Not all the same");

        int resultInt = aEqualsB && bEqualsC ? 1 : -1;
    }
}
