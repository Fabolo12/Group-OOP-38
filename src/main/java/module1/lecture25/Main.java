package module1.lecture25;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        readFromArray();
//        readFromArrayAvailable();
//        writeObject();
//        readObject();

        // -Xmx256M -Xms256M
        final Runtime runtime = Runtime.getRuntime();
        System.out.println("Free memory: " + (runtime.freeMemory() / 1_000_000_000.0));
        System.out.println("Total memory: " + (runtime.totalMemory() / 1_000_000_000.0));
        System.out.println("Max memory: " + (runtime.maxMemory() / 1_000_000_000.0));
    }

    private static void readFromArray() {
        byte[] array = {1, 2, 3, 4};
        ByteArrayInputStream input = new ByteArrayInputStream(array);

        for (int i = 0; i < array.length; i++) {
            int data = input.read();
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    private static void readFromArrayAvailable() {
        byte[] array = {1, 2, 3, 4};

        ByteArrayInputStream input = new ByteArrayInputStream(array);
        System.out.println("байтів, доступних для читання  " + input.available());

        input.read();
        System.out.println("байтів, вільних для читання " + input.available());

        input.read();
        System.out.println("байтів, вільних для читання " + input.available());
    }

    private static void writeObject() throws IOException {
        Dog dog = new Dog("Tyson", "Labrador");


        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(
                "src/main/java/module1/lecture25/file.txt"
        ));
        output.writeObject(dog);
        output.close();
    }

    private static void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "src/main/java/module1/lecture25/file.txt"
        ));

        Dog newDog = (Dog) input.readObject();

        System.out.println("Dog Name: " + newDog.name);
        System.out.println("Dog Breed: " + newDog.breed);
        System.out.println("Dog id: " + newDog.id);
    }

    static class Dog implements Serializable {
        transient String name;

        String breed;

        @Serial
        private static final long serialVersionUID = 1;

        String id;

        public Dog(final String name, final String breed) {
            this.name = name;
            this.breed = breed;
        }
    }
}
