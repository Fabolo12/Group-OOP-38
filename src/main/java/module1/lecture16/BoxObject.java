package module1.lecture16;

public class BoxObject {
    private Object value;

    public BoxObject(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public static void main(String[] args) {
        final BoxObject box = new BoxObject(10);
        final Object value = box.getValue();
        if (value instanceof Integer invValue) {
            final int sum = invValue + 10;
            System.out.println(sum);
        }
    }
}
