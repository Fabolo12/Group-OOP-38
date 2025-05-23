package module3.lecture14;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {
    @SneakyThrows
    public static void main(String[] args) {
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();

        //Create MyCallable instance
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100; i++) {
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }

        int count = 0;
        do {
            final Optional<Future<String>> optionalFuture = list.stream()
                    .filter(Future::isDone)
                    .findAny();

            if (optionalFuture.isPresent()) {
                System.out.println(new Date() + "::" + optionalFuture.get().get());
                count++;
            } else {
                System.out.println("Waiting for any thread to finish");
            }
        } while (count < list.size());


        //shut down the executor service now
        executor.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }
}
