package module1.lecture18;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class SameKey {
    public static void main(String[] args) {
        final Map<Box, Integer> boxes = new LinkedHashMap<>();
        final Box box1 = new Box();
        box1.id = "id1";

        final Box box2 = new Box();
        box2.id = "id2";

        boxes.put(box1, 10);
        boxes.put(box2, 100);

        System.out.println(boxes);
        System.out.println(boxes.get(box2));

        box2.id = "id1";
        System.out.println(boxes);
        System.out.println(boxes.get(box2));
    }

    record BoxKey(String id) {

    }

    static class Box {
        String id;

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
                    "id='" + id + '\'' +
                    '}';
        }
    }
}
