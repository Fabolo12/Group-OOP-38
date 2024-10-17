package module1.lecture15;

public class ClassExample {
    public static void main(String[] args) throws ClassNotFoundException {
        final Class<Integer> integerClass = int.class;
        Integer integer = 5;
        final Class<? extends Integer> aClass = integer.getClass();
        final Class<Integer> integerClass1 = Integer.class;
        final Class<?> aClass1 = Class.forName("java.lang.Integer");


    }
}
