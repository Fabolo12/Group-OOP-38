package module3.lecture11;

import java.util.Iterator;

public class Adapter {

    public static void main(String[] args) {
        final Integer[] array = {1, 2, 3, 4, 5};
        final ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array, 2);

        System.out.println("ArrayIterator with lambda");
        arrayIterator.forEachRemaining(System.out::println);

        arrayIterator.reset();

        System.out.println("ArrayIterator with while loop");
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }

    static class ArrayIterator<E> implements Iterator<E> {

        private final E[] array;

        private final int delta;

        private int index = 0;

        public ArrayIterator(final E[] array, final int delta) {
            this.array = array;
            this.delta = delta;
        }

        @Override
        public boolean hasNext() {
            return index < array.length - delta;
        }

        @Override
        public E next() {
            final E e = array[index];
            index += delta;
            return e;
        }

        @Override
        public void remove() {
            array[index] = null;
        }

        public void reset() {
            index = 0;
        }
    }
}
