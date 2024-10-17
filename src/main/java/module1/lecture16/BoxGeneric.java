package module1.lecture16;

public class BoxGeneric<V> {
    private V value;

    public BoxGeneric(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void print() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        final BoxGeneric<Integer> boxInteger = new BoxGeneric<>(10);
        final BoxGeneric<String> boxString = new BoxGeneric<>("10");
        final BoxGeneric<int[]> boxArray = new BoxGeneric<>(new int[]{10, 20, 30});

        final Integer value1 = boxInteger.getValue();
        System.out.println(value1 + 10);
        boxInteger.print();
        boxString.print();
        boxArray.print();
    }
}
