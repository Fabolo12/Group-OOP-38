package module2.lecture9;

public class Main5 {
    public static void main(String[] args) {
        final Box box = new Box();
        final Box clone = box.copy();
        print(box, clone);

        System.out.println("~".repeat(10));

        final Box box2 = new Box();
        final Box clone2 = new Box(box2);
        print(box2, clone2);
    }

    private static void print(final Box box, final Box clone) {
        System.out.println(box);
        System.out.println(clone);

        box.size = 11;
        System.out.println(box);
        System.out.println(clone);

        box.item.name = "Item2";
        System.out.println(box);
        System.out.println(clone);
    }

    static class Box {
        int size = 10;
        String name = "Box";
        Item item = new Item();

        public Box() {
        }

        public Box(final Box box) {
            this.size = box.size;
            this.name = box.name;
            this.item = new Item(box.item);
        }

        public Box copy() {
            final Box clone = new Box();
            clone.size = size;
            clone.name = name;
            final Item item = new Item();
            item.name = this.item.name;
            clone.item = item;
            return clone;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "size=" + size +
                    ", name='" + name + '\'' +
                    ", item=" + item +
                    '}';
        }
    }

    static class Item {
        String name = "Item";

        public Item() {
        }

        public Item(final Item item) {
            this.name = item.name;
        }

        public Item copy() {
            final Item clone = new Item();
            clone.name = name;
            return clone;
        }

        @Override
        public String toString() {
            return "Item{" + name + '}';
        }
    }
}
