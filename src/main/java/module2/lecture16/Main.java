package module2.lecture16;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        final Class<?> class1 = Class.forName("module2.lecture16.Main");
        final Cat cat = new RedCat();
        final Class<? extends Cat> class2 = cat.getClass();
        final Class<Cat> class3 = Cat.class;
        final Class<Integer> integerClass = int.class;
        final Class<Void> voidClass = void.class;

        System.out.println("getFields");
        Arrays.stream(class3.getFields()).forEach(System.out::println);
        System.out.println("getDeclaredFields");
        Arrays.stream(class3.getDeclaredFields()).forEach(System.out::println);

        System.out.println();
        System.out.println("getMethods");
        Arrays.stream(class3.getMethods()).forEach(System.out::println);
        System.out.println("getDeclaredMethods");
        Arrays.stream(class3.getDeclaredMethods()).forEach(System.out::println);

        final Field catName = class3.getField("catName");
        System.out.println(catName.getModifiers());
        System.out.println(Modifier.toString(catName.getModifiers()));

    }

    static class Animal {
        public String animalName;

        private int animalAge;
    }

    static class Cat extends Animal {
        public final String catName = "";
        private int catAge;
    }

    static class RedCat extends Cat {

    }
}
