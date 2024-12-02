package module2.lecture9;

public class Main7 {
    public static void main(String[] args) throws ClassNotFoundException {
        final Class<Integer> clazz = Integer.class;
        final Class<Integer> integerClass = int.class;
        final Class<Void> voidClass = void.class;
        final Class<?> aClass = Class.forName("module2.lecture9.Main10");
        final Box box = new SmallBox();
        final Class<? extends Box> aClass1 = box.getClass();
    }

    static class Box {

    }

    static class SmallBox extends Box {

    }
}
