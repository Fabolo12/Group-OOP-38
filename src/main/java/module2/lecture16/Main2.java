package module2.lecture16;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Animal animal = new Animal();

        System.out.println(animal.getName());

        final Class<Animal> animalClass = Animal.class;
        Arrays.stream(animalClass.getDeclaredFields())
                .filter(field -> field.getName().equals("name"))
                .findFirst()
                .ifPresent(field -> {
                    try {
                        field.setAccessible(true);
                        field.set(animal, "Animal");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(animal.getName());
        System.out.println(animal.getName().equals("Animal"));

        final Method printName = animalClass.getDeclaredMethod("printName2");
        printName.setAccessible(true);
        printName.invoke(animal);

        AnimalLogger animal1 = new AnimalLogger();
        animal1.printName();
    }
}

class Animal {
    public final String name = "default value";

    public String getName() {
        return name;
    }

    public void printName2() {
        System.out.println(name);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class AnimalLogger extends Animal {

    public void printName() {
        try {
            final Class<Animal> animalClass = Animal.class;
            final Method printName = animalClass.getMethod("printName2");
            printName.setAccessible(true);
            final Date start = new Date();
            printName.invoke(this);
            final Date end = new Date();
            System.out.println("Method execution time: " + (end.getTime() - start.getTime()) + " ms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
