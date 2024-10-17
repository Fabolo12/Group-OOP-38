package module1.lecture16;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        final Pair<Integer, String> pair = new Pair<>(1, "One");
        final Integer key = pair.getKey();
        final String value = pair.getValue();
        System.out.println(key + " - " + value);
    }
}

class ChildPair1<K, V> extends Pair<K, V> {
    public ChildPair1(K key, V value) {
        super(key, value);
    }
}

class ChildPair2<K, V, T> extends Pair<K, V> {
    private T otherValue;

    public ChildPair2(K key, V value, T otherValue) {
        super(key, value);
        this.otherValue = otherValue;
    }
}

class ChildPair3<V> extends Pair<String, V> {
    public ChildPair3(String key, V value) {
        super(key, value);
    }
}

class ChildPair4 extends Pair<String, Integer> {
    public ChildPair4(String key, Integer value) {
        super(key, value);
    }
}