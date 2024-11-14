package module2.lecture5;

public class Cal<T extends Number> {
    public static void main(String[] args) {
        final Cal<Integer> intCal = new Cal<>();
        System.out.println(intCal.sub(1, 2));

        final Cal<Double> doubleCal = new Cal<>();
        System.out.println(doubleCal.sub(1.5, 2.7));

//        final Cal<String> stringCal = new Cal<>();
    }

    public Double sum(final T a, final T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Double sub(final T a, final T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Double mul(final T a, final T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public Double div(final T a, final T b) {
        return a.doubleValue() / b.doubleValue();
    }
}
