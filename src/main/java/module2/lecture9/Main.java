package module2.lecture9;

public class Main {

    public static void main(String[] args) {
        new Child();
    }

    static class Paren extends Object {

        private static int count = 0; // 1

        private int id; // 5

        static {
            System.out.println("Parent static block"); // 2
        }

        {
            System.out.println("Parent instance block"); // 6
        }

        public Paren() {
            System.out.println("Parent constructor"); // 7
        }
    }

    static class Child extends Paren {

        private static int count = 0; // 3

        private int id; // 8

        static {
            System.out.println("Child static block"); // 4
        }

        {
            System.out.println("Child instance block"); // 9
        }

        public Child() {
            System.out.println("Child constructor"); // 10
        }


    }
}
