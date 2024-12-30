package module2.lecture14;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Main {

    private static final String FILE_NAME = "src/main/java/module2/lecture14/cat.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            Cat cat = new Cat();
            outputStream.writeObject(cat);
            Dog dog = Dog.getInstance();
            outputStream.writeObject(dog);
        }

        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object object1 = objectStream.readObject();
            Cat newCat = (Cat) object1;
            System.out.println(newCat);

            Object object2 = objectStream.readObject();
            Dog newDog = (Dog) object2;
            System.out.println(newDog);

            Dog dog = Dog.getInstance();
            System.out.println(dog == newDog);
            System.out.println(dog == dog);
        }
    }

    static class Cat implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private String name = "Cat";

        private int age = 5;

        private transient Kitten kitten = new Kitten();

        public Cat() {
            System.out.println("Cat constructor");
        }

        @Override
        public String toString() {
            return "Cat{" +
//                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", kitten=" + kitten +
                    '}';
        }
    }

    static class Kitten {
        private static final long serialVersionUID = 1L;

        private String name = "Kitten";

        private int age = 1;

        @Override
        public String toString() {
            return "Kitten{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Dog implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name = "Dog";

        private int age = 5;

        private static final Dog INSTANCE = new Dog();

        private Dog() {
        }

        public static Dog getInstance() {
            return INSTANCE;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
