package module1.lecture17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListCompare {
    public static void main(String[] args) {
        final List<String> arrayList = new ArrayList<>();
        final List<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100_000; i++) {
            arrayList.add("Hello");
            linkedList.add("Hello");
        }


        final long start = System.currentTimeMillis();
        listOperation(arrayList);
        final long end = System.currentTimeMillis();
        System.out.println("ArrayList: " + (end - start) + " ms");

        final long start2 = System.currentTimeMillis();
        listOperation(linkedList);
        final long end2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (end2 - start2) + " ms");
    }

    // add(value) ArrayList > LinkedList
    // add(index, value) ArrayList < LinkedList
    // get(index) ArrayList > LinkedList
    // set(index, value) ArrayList > LinkedList
    // remove(index) ArrayList > LinkedList
    private static void listOperation(final List<String> list) {
        for (int i = 0; i < 150_000; i++) {
            list.get(30_000);
        }
    }
}
