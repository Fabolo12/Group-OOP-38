package module2.lecture9;

public class Main4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        final Box box = new Box();
        final Box clone = (Box) box.clone();
        System.out.println(box);
        System.out.println(clone);

        box.size = 11;
        System.out.println(box);
        System.out.println(clone);

        box.item.name = "Item2";
        System.out.println(box);
        System.out.println(clone);
    }

    static class Box implements Cloneable {
        int size = 10;
        String name = "Box";
        Item item = new Item();

        @Override
        public Object clone() throws CloneNotSupportedException {
            final Box clone = (Box) super.clone();
            clone.item = (Item) item.clone();
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

    static class Item implements Cloneable  {
        String name = "Item";

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Item{" + name + '}';
        }
    }
}
