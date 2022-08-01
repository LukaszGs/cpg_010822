package com.for_comprehension.function.l1_function;

import java.util.function.Function;

public class LambdaAnatomy {
    /*
    (String a, String b) -> {
        return a + b;
    }

    (a, b) -> {
        return a + b;
    }

    (a, b) -> a + b;

    a -> a + 1;

    () -> 42;

    () -> {}
     */

    public class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello");
        }

    }

    public static void main(String[] args) {
        // before JDK8
        process(new Runnable() {

            @Override
            public void run() {
                System.out.println("Hello");
            }
        });

        // JDK8+
        process(() -> System.out.println("Hello"));

        Function<Integer, String> intToString = Object::toString;
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }

}
