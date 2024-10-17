package module1.lecture16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MyArrayList {
    public static void main(String[] args) {
        final List<Integer> numbers1 = new ArrayList<>(); // default 10
        // size += size/2 + 1
        final List<Integer> numbers2 = new ArrayList<>(100);

        System.out.println("Size: " + numbers2.size());
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers2.add(random.nextInt(100));
        }
        System.out.println("Size: " + numbers2.size());

        for (int i = 0; i < numbers2.size(); i++) {
            System.out.println(numbers2.get(i));
        }

        for (Integer number : numbers2) {
            System.out.println(number);
        }

        final Iterator<Integer> iterator = numbers2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        final ListIterator<Integer> integerListIterator = numbers2.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }
        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }
    }
}
