package com.for_comprehension.function;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Scratchpad {

    private static volatile Long foo = 42L;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            foo = 1L;
        });

        executorService.submit(() -> {
            while (true) {
                Thread.sleep(100);
                System.out.println(foo);
            }
        });

    }
}
