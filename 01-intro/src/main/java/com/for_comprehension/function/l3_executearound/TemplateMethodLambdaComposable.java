package com.for_comprehension.function.l3_executearound;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class TemplateMethodLambdaComposable {

    public static void main(String[] args) {
        /*System.out.println("Entering method");
        process();
        System.out.println("Exiting method");*/

        Integer integer =
            timed(
                logged(
                    () -> process())).get();

        System.out.println(integer);

    }

    public static int process() {
        System.out.println("calculating...");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 42;
    }

    public static <T> Supplier<T> timed(Supplier<T> action) {
        return () -> {
            var before = Instant.now();
            T result = action.get();
            var after = Instant.now();

            System.out.println(Duration.between(before, after).toMillis() + "ms");

            return result;
        };
    }

    public static <T> Supplier<T> logged(Supplier<T> supplier) {
        return () -> {
            System.out.println("Entering method");
            var result = supplier.get();
            System.out.println("Exiting method");
            return result;
        };
    }
}
