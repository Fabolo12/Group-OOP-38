package module1.lecture13;

public class Main2 {
    public static void main(String[] args) {
        if (method1() || method2()) {
            System.out.println("true");
        }
    }

    private static boolean method1() {
        System.out.println("method1");
        return true;
    }

    private static boolean method2() {
        System.out.println("method2");
        return true;
    }
}
