package module1.lecture17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RemoveFromCollection {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.add("World");

        for (String s : list) {
            if (s.equals("World")) {
                list.remove("World");
            }
        }

        /*final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (s.equals("World")) {
                iterator.remove();
            }
        }*/

        /*for (int i = 0; i < list.size(); i++) {
            final String s = list.get(i);
            if (s.equals("World")) {
                list.remove("World");
            }
        }*/

        final Set<String> strings = new HashSet<>(list);
        list.removeIf(s -> s.equals("World"));

        System.out.println("List: " + list);
        System.out.println("Set: " + strings);
    }
}
