package module1.lecture9;

public class Main5 {
    public static void main(String[] args) {
        print("Hello, World!");
        String line = getLine("Hello, World!");
        System.out.println(line);

        System.out.println("~".repeat(10));
        String line2 = "Hello";
        System.out.println("line2 before method call = " + line2);
        methodWithString(line2);
        System.out.println("line2 after method call = " + line2);

        System.out.println("~".repeat(10));
        String line3 = "Hello";
        System.out.println("line3 before method call = " + line3);
        String line4 = methodWithString2(line3);
        System.out.println("line3 after method call = " + line3);
        System.out.println("line4 after method call = " + line4);
    }

    private static void methodWithString(String param) {
        System.out.println("param before change = " + param);
        param += " world";
        System.out.println("param after change = " + param);
    }

    private static String methodWithString2(String param) {
        System.out.println("param before change = " + param);
        param += " world";
        System.out.println("param after change = " + param);
        return param;
    }

    private static void print(String line) {
        System.out.println("***" + line + "***");
    }

    private static String getLine(String line) {
//        return "***" + line + "***";
        String newLine = "***" + line + "***";
        return newLine;
    }
}
