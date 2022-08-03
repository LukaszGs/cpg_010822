package com.for_comprehension.function.l5_threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class L6_ParallelStream {

    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return 42;
        });

        cf1.join();

        Stream.of(1, 2, 3, 4)
            .parallel()
            .forEach(a -> {
                System.out.println(Thread.currentThread().getName());
            });

    }

    public static void cancellation() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> f = executorService.submit(() -> 42);
        f.cancel(true);

        CompletableFuture<Integer> cf1 = new CompletableFuture<>();

        cf1.cancel(true);
        cf1.join();
    }

}
