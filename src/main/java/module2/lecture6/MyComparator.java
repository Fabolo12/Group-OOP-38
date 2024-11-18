package module2.lecture6;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass> {
    @Override
    public int compare(final MyClass o1, final MyClass o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}
