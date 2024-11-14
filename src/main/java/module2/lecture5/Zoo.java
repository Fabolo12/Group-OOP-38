package module2.lecture5;

public class Zoo<K> {
    public static void main(String[] args) {
        final Zoo<String> zoo = new Zoo<>();
        zoo.<Integer>add("Lion", 3);
        zoo.add("Tiger", 2L);
        zoo.add("Tiger", 0.5D);
        zoo.add("Tiger", 0.5F);
        Zoo.add2("Tiger", 0.5F);
    }

    public static <T extends Number> void add2(final String animal, final T count) {
        System.out.println("Added " + count + " " + animal);
    }

    public <T extends Number> void add(final K animal, final T count) {
        System.out.println("Added " + count + " " + animal);
    }
}
