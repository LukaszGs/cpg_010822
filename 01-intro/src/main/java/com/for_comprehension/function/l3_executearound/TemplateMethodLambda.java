package com.for_comprehension.function.l3_executearound;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class TemplateMethodLambda {

    public static void main(String[] args) {
        /*System.out.println("Entering method");
        process();
        System.out.println("Exiting method");*/

        Integer result = timed(() -> process());

        System.out.println(result);
    }

    public static int process() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("calculating...");
        return 42;
    }

    public static <T> T timed(Supplier<T> action) {
        var before = Instant.now();
        T result = action.get();
        var after = Instant.now();

        System.out.println(Duration.between(before, after).toMillis() + "ms");

        return result;
    }

    public static void runWithLogging(Runnable runnable) {
        System.out.println("Entering method");
        runnable.run();
        System.out.println("Exiting method");
    }
}
