package module1.lecture27;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

    public static final String message = "Схоже, що в об'єкта класу Human не ініціалізований список дітей.";

    public static void main(String[] args) {
        Human amigo = new Human("Amigo", 25, new ArrayList<>());
        System.out.printf("Ім'я: %s, вік: %d, кількість дітей: %d%n", amigo.getName(), amigo.getAge(), getChildrenCount(amigo));

        Human diego = new Human("Diego", 35);
        System.out.printf("Ім'я: %s, вік: %d, кількість дітей: %d%n", diego.getName(), diego.getAge(), getChildrenCount(diego));
    }

    public static int getChildrenCount(Human human) {
        int size = human.getChildren() == null ? 0 : human.getChildren().size();

        //напишіть тут ваш код
        try {
//            size = human.getChildren().size();
        } catch (NullPointerException e) {
           throw new ChildrenNotInitializedException(message, e);
        }

        return size;
    }

    static class Human {
        private String name;
        private int age;
        private List<Human> children;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, ArrayList<Human> children) {
            this(name, age);
            this.children = children;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<Human> getChildren() {
            return children;
        }
    }

    static class ChildrenNotInitializedException extends RuntimeException {
        public ChildrenNotInitializedException(String message) {
            this(message, null);
        }

        public ChildrenNotInitializedException(final String message, final Throwable cause) {
            super(message, cause);
            System.out.println(message);
        }
    }
}
