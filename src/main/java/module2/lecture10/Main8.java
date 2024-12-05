package module2.lecture10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main8 {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        Runnable run = () -> System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        new Thread(run).start();
        new Thread(run).start();

        TimeUnit.SECONDS.sleep(3);

        final List<Integer> integers1 = list.subList(0, 500);
        final List<Integer> integers2 = list.subList(500, 1000);

        Runnable run1 = () -> System.out.println(integers1.stream().mapToInt(Integer::intValue).sum());
        Runnable run2 = () -> System.out.println(integers2.stream().mapToInt(Integer::intValue).sum());
        new Thread(run1).start();
        new Thread(run2).start();
    }
}
