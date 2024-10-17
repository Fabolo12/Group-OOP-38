package module1.lecture17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Box {
    int width;

    String id;

    public Box(final int width) {
        this.width = width;
        id = UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        final Box box1 = new Box(10);
        final Box box2 = new Box(11);

        final List<Box> boxList = new ArrayList<>();
        boxList.add(box1);
        boxList.add(box2);
        System.out.println("List: " + boxList);

        final Set<Box> boxSet = new HashSet<>();
        boxSet.add(box1);
        box2.id = box1.id;
        boxSet.add(box2);
        System.out.println("Set: " + boxSet);

        final Set<String> stringSet = new HashSet<>();
        stringSet.add("Hello");
        stringSet.add("Hello");
        System.out.println("String Set: " + stringSet);

        final Set<Box> boxSet2 = new HashSet<>();
        boxSet2.add(box1);
        for (Box box : boxSet2) {
            System.out.println("Box: " + box);
        }

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Box box = (Box) o;
        return Objects.equals(id, box.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", id='" + id + '\'' +
                '}';
    }
}
