package module1.lecture18;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorExamples {
    public static void main(String[] args) {
        final Set<Integer> sets = new TreeSet<>(new IntComparator().reversed());
        sets.add(1);
        sets.add(2);
        sets.add(3);
        sets.add(4);
        System.out.println(sets);

        final Set<Box> sets2 = new TreeSet<>(
                new BoxNameComparator().reversed().thenComparing(new BoxSizeComparator().reversed())
        );
        sets2.add(new Box(15, "Box1"));
        sets2.add(new Box(8, "Box1"));
        sets2.add(new Box(3, "Box2"));
        sets2.add(new Box(4, "Box3"));
        System.out.println(sets2);
    }

    static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(final Integer o1, final Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    static class Box {
        int size;
        String name;

        public Box(int size, String name) {
            this.size = size;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "size=" + size +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class BoxNameComparator implements Comparator<Box> {
        @Override
        public int compare(final Box o1, final Box o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    static class BoxSizeComparator implements Comparator<Box> {
        @Override
        public int compare(final Box o1, final Box o2) {
            return Integer.compare(o1.size, o2.size);
        }
    }
}
