package module1.lecture9.inner;

import module1.lecture8.PublicClass;
import module1.lecture9.LocalClass;

public class Main {
    public static void main(String[] args) {
        PublicClass.publicMethod();
//        PublicClass.protectedMethod(); ERROR
//        LocalClass.protectedMethod(); ERROR
//        LocalClass.defaultMethod(); ERROR
//        LocalClass.privateMethod(); ERROR
//        privateMethod(); ERROR
    }
}
