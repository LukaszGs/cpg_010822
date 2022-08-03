package com.for_comprehension.function.l5_threads;

public class L7_VirtualThread {

    /*public static void main(String[] args) throws InterruptedException {
        try (ExecutorService e = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100000; i++) {
                e.submit(() -> {
                    e.submit(() -> {
                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                });
            }
        }

        System.out.println("finished");
    }*/

}
