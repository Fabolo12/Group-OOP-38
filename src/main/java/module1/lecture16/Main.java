package module1.lecture16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers1 = new ArrayList<>();
        final long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            numbers1.addFirst(0);
        }
        final long end1 = System.currentTimeMillis();
        System.out.println("Time1: " + (end1 - start1));


        final List<Integer> numbers2 = new ArrayList<>();
        final long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            numbers2.add(0);
        }
        final long end2 = System.currentTimeMillis();
        System.out.println("Time2: " + (end2 - start2));

        final ArrayList<Integer> numbers3 = new ArrayList<>();
        numbers3.trimToSize();

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(numbers1);
        numbers3.addAll(numbers1);

        numbers3.remove(10);

        for (Integer number : numbers3) {
            if (number % 2 == 0) {
                numbers3.set(number, 0);
            }
        }
    }
}
