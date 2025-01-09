package module2.lecture16;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        final Class<Dog> dogClass = Dog.class;
        Arrays.stream(dogClass.getDeclaredConstructors())
                .filter(constructor -> constructor.getParameterCount() == 0)
                .map(constructor -> {
                    try {
                        constructor.setAccessible(true);
                        return constructor.newInstance();
                    } catch (InstantiationException | IllegalAccessException |
                             java.lang.reflect.InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .findFirst()
                .ifPresent(System.out::println);
    }

    static class Dog {
        private String name = "Dog";

        @Deprecated
        private Dog() {
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
