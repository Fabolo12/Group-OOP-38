package module2.lecture5;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    interface MyInterface<K, V> {
        void doSomething(K k, V v);
    }

    interface MyInterface2<K, V> extends MyInterface<K, V> {
        void doSomething(K k, V v);
    }

}

class Pair2<K, V> extends Pair<K, V> {
    public Pair2(final K key, final V value) {
        super(key, value);
    }
}

class Pair3<K, V, E> extends Pair<K, V> {
    private final E e;

    public Pair3(final K key, final V value, final E e) {
        super(key, value);
        this.e = e;
    }
}

class Pair4<V> extends Pair<String, V> {
    public Pair4(final String key, final V value) {
        super(key, value);
    }
}

class Pair5 extends Pair<String, Integer> {
    public Pair5(final String key, final Integer value) {
        super(key, value);
    }
}