package com.for_comprehension.function.l5_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class L3_ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService foo = new ThreadPoolExecutor(4, 20,
            10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(85),
            named("xD"));

        for (int i = 0; i < 100; i++) {
            foo.submit(() -> {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(10000));
                }
                catch (InterruptedException e) {
                }
            });
        }
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
