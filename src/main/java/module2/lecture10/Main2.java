package module2.lecture10;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        List.of(new MyThread(), new MyThread(), new MyThread())
                .forEach(MyThread::start);

        final Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        List.of(new MyThread2(), runnable)
                .forEach(run -> new Thread(run).start());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
