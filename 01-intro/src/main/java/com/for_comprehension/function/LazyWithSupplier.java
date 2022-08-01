package com.for_comprehension.function;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

class LazyWithSupplier {

    public static void main2(String[] args) {
        int v = ThreadLocalRandom.current().nextInt();
        processEager(v);

        Supplier<Integer> vs = () -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalRandom.current().nextInt();
        };
        processLazy(vs);

    }

    public static void main(String[] args) {
        processEager(ThreadLocalRandom.current().nextInt());

        processLazy(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalRandom.current().nextInt();
        });

    }

    public static int processEager(int v) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 1) {
            return v;
        }

        return 42;
    }

    public static int processLazy(Supplier<Integer> v) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 1) {
            return v.get();
        }

        return 42;
    }




}
