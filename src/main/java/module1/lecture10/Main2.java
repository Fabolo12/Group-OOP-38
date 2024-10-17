package module1.lecture10;

public class Main2 {
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println("Number: " + number);

        int number = 20;

        System.out.println("Number: " + number);

        String line = "123";
        System.out.println("equals " + line.equals("123"));
        System.out.println("flip equals " + "123".equals(line));
        System.out.println("startsWith " + line.startsWith("1"));
        System.out.println("endsWith " + line.endsWith("4"));
    }
}
