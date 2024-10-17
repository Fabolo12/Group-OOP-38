package module1.lecture18;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeMain {
    public static void main(String[] args) {
        Comparator comparator = "param2".equals("param")
                ? new BoxComparatorWithoutDuplicate() : new BoxComparatorWithDuplicate();

        final Set<Box> ints2 = new TreeSet<>(comparator);
        ints2.add(new Box(1, "Box1"));
        ints2.add(new Box(2, "Box2"));
        ints2.add(new Box(1, "Box1"));
        System.out.println(ints2);
    }

    record Box(int size, String name)/* implements Comparable<Box>*/ {
       /* @Override
        public int compareTo(final Box o) {
            final int compare = name.compareTo(o.name);
            final int compare2 = Integer.compare(name.length(), o.name.length());
            return compare == 0 ? 1 : compare;
        }*/
    }

    static class BoxComparatorWithDuplicate implements Comparator<Box> {
        @Override
        public int compare(final Box o1, final Box o2) {
            final int compare = o1.name.compareTo(o2.name);
            return compare == 0 ? 1 : compare;
        }
    }

    static class BoxComparatorWithoutDuplicate implements Comparator<Box> {
        @Override
        public int compare(final Box o1, final Box o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
