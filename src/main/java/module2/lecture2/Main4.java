package module2.lecture2;

public class Main4 {
    public static void main(String[] args) {
        final Parent parent = new Parent();
        final Child child = new Child();
        final Parent parent2 = new Child();

        final Number p1 = parent.print();
        final Integer p2 = child.print();
        final Number p3 = parent2.print();
    }

    static class Parent {
        public Number print() {
            System.out.println("Parent");
            return 1;
        }
    }

    static class Child extends Parent {
        @Override
        public Integer print() {
            System.out.println("Child");
            return 2;
        }
    }
}
