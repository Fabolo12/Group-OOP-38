package module1.lecture9;

import module1.lecture8.PublicClass;

public class Main {
    public static void main(String[] args) {
        PublicClass.publicMethod();
//        PublicClass.protectedMethod(); ERROR
        LocalClass.protectedMethod();
        LocalClass.defaultMethod();
//        defaultMethod();
//        LocalClass.privateMethod(); ERROR
        privateMethod();

//        privateMethodNotStatic(); ERROR
    }

/*    static void defaultMethod() {
        System.out.println("Hello, World!");
    }*/

    private static void privateMethod() {
        System.out.println("Hello, World!");
    }

    private void privateMethodNotStatic() {
        System.out.println("Hello, World!");
    }

}