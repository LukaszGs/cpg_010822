package com.for_comprehension.function.l5_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class L2_ThreadPools {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(
            4, named("mailer-thread"));

        executor.submit(() -> {
            System.out.println("Returning 42 from thread: " + Thread.currentThread().getName());
            return 42;
        });

        executor.submit(() -> {
            System.out.println("Returning 42 from thread: " + Thread.currentThread().getName());
            return 42;
        });
        executor.submit(() -> {
            System.out.println("Returning 42 from thread: " + Thread.currentThread().getName());
            return 42;
        });
        executor.submit(() -> {
            System.out.println("Returning 42 from thread: " + Thread.currentThread().getName());
            return 42;
        });

        executor.shutdown();
    }

    private static ThreadFactory named(String name) {
        return new ThreadFactory() {

            private final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, name + "-" + counter.incrementAndGet());
            }
        };
    }

}
