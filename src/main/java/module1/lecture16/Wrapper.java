package module1.lecture16;

public class Wrapper {
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        Integer c = Integer.valueOf(a.intValue() + b);
    }
}
