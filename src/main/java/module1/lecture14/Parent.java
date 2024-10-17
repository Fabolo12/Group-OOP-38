package module1.lecture14;

public class Parent {

    static { // 1
        System.out.println("Static block Parent");
    }

    { // 5
        System.out.println("Non-static block Parent");
    }

    static int a = 5; // 2

    int b = 10; // 6/7

    public Parent() { // 9
        System.out.println("Constructor Parent");
    }

    public static void main(String[] args) {
        Child parent = new Child();
    }
}

class Child extends Parent {

    static { // 3
        System.out.println("Static block Child");
    }

    { // 6/7
        System.out.println("Non-static block Child");
    }

    static int c = 15; // 4

    int d = 20; // 8

    public Child() { // 10
        System.out.println("Constructor Child");
    }
}