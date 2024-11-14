package module2.lecture5;

public class Main {
    public static void main(String[] args) {
        final Pair<Object, Object> pair1 = new Pair<>("key", "value");
        final Pair pair2 = new Pair(1, 2);

        System.out.println(pair1);
        System.out.println(pair2);
        final Object key1 = pair1.getKey();
        final Object key2 = pair2.getKey();

        final Pair<String, String> pair3 = new Pair<>("key", "value");
        final Pair<Integer, Integer> pair4 = new Pair<>(1, 2);
        final String key3 = pair3.getKey();
        final Integer key4 = pair4.getKey();

        final Pair<String, Integer> pair5 = new Pair<>("key", 2);
        final String key5 = pair5.getKey();
        final Integer value5 = pair5.getValue();

        final Pair2<Integer, Integer> pair6 = new Pair2<>(1, 1);
        final Pair3<Integer, Integer, Integer> pair7 = new Pair3<>(1, 1, 1);
        final Pair4<Integer> pair8 = new Pair4<>("key", 1);
        final Pair5 pair9 = new Pair5("key", 1);
    }
}
