package com.for_comprehension.function;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Scratchpad {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(4);

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        Future<?> submit = e.submit(() -> {
            queue.add(1);
        });
        Future<?> f2 = e.submit(() -> {
            queue.add(2);
        });
        Future<?> f3 = e.submit(() -> {
            queue.add(3);
        });

        Integer integer = queue.take();

        System.out.println(integer);

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            return 11;
        });
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            return 22;
        });

        cf1
            .applyToEither(cf2, i -> i)
            .thenAccept(System.out::println)
            .join();


    }

}
