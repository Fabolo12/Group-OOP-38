package module2.lecture9;

public class Main2 {
    public static void main(String[] args) {
        String line1 = "Hello";
        String line2 = "Hello";
        String line3 = new String("Hello");

        System.out.println(line1 == line2);
        System.out.println(line1 == line3);
        System.out.println(line1.equals(line2));
        System.out.println(line1.equals(line3));

        System.out.println(Color.RED == Color.RED);
        System.out.println(Color.RED.equals(Color.RED));
    }

    enum Color {
        RED, GREEN, BLUE
    }
}
