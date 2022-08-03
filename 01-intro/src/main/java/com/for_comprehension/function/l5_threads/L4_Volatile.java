package com.for_comprehension.function.l5_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L4_Volatile {

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
