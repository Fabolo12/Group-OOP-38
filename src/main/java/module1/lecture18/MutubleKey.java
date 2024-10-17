package module1.lecture18;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class MutubleKey {
    public static void main(String[] args) {
        final Map<Box, Integer> boxes = new HashMap<>();
        final Box box1 = new Box();
        box1.id = UUID.randomUUID().toString();
        box1.name = "Box1";

        boxes.put(box1, 10);
        System.out.println(box1.hashCode());
        System.out.println(boxes.get(box1));

        box1.name = "Box2";
        System.out.println(box1.hashCode());
        System.out.println(boxes.get(box1));
    }

    static class Box {
        String id;

        String name;

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
    }
}
