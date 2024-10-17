package module1.lecture4;

public class Main5 {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;

        boolean result1 = a == b;
        System.out.println("a == b = " + result1);

        String st1 = "5";
        System.out.println("a == st1 = " + (a + "" == st1));

        System.out.println("a equals st1 = " + (st1.equals(a + "")));

        String st2 = "5";
        System.out.println("st1 == st2 = " + (st1.equals(st2)));

        String st3 = "test";
        String st4 = "TEST";
        System.out.println("st3 == st4 = " + (st3.equals(st4)));
        System.out.println("st3 == st4 = " + (st3.equalsIgnoreCase(st4)));
        System.out.println("st3 == st4 = " + (st3.toLowerCase().equals(st4.toLowerCase())));
    }
}
