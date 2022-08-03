package com.for_comprehension.function.l5_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L7_VirtualThread {

    public static void main(String[] args) throws InterruptedException {
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
       /* Thread hello_from_virtual_thread = Thread.ofVirtual()
            .name("fooooooo")
            .start(() -> {
            try {
                Thread.sleep(1000000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hello from virtual thread");

        });

        hello_from_virtual_thread.join();*/

    }

}
