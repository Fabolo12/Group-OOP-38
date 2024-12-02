package module2.lecture9;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        final String line = "Hello World";
        final String line2 = line + "!";
        System.out.println(line == line2);
        Integer i = 1000;
        Integer j = i + 1;
        System.out.println(i == j);

        final ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        final Box box = new Box(0, numbers);
        System.out.println(box);

        int i1 = box.getI();
        i1 = 5;
        final List<Integer> numbers1 = box.getNumbers();
        numbers1.add(3);
        numbers.add(4);
//        final ChangeBox box1 = (ChangeBox) box;
//        box1.changeNumbers(5);

        System.out.println(box);

        final Date date = new Date();
        date.setDate(1);
        final LocalDate now = LocalDate.now();
        final LocalDate localDate = now.plusMonths(1);
    }

    static final class Box {
        private final int i;
        private final List<Integer> numbers;

        public Box(final int i, final List<Integer> numbers) {
            this.i = i;
            this.numbers = new ArrayList<>(numbers);
        }

        public int getI() {
            return i;
        }

        public List<Integer> getNumbers() {
            return new ArrayList<>(numbers);
        }

        @Override
        public String toString() {
            return "Box{" +
                    "i=" + i +
                    " numbers=" + numbers +
                    '}';
        }
    }

    /*static class ChangeBox extends Box {
        public ChangeBox(int i, List<Integer> numbers) {
            super(i, numbers);
        }

        public void changeNumbers(int i) {
            numbers.add(i);
        }
    }*/
}
