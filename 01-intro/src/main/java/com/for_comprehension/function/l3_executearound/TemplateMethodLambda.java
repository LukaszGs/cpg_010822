package com.for_comprehension.function.l3_executearound;

import java.time.Duration;
import java.time.Instant;

public class TemplateMethodLambda {

    public static void main(String[] args) {
        /*System.out.println("Entering method");
        process();
        System.out.println("Exiting method");*/

        runWithLogging(() -> process());

        Instant now = Instant.now();
        Instant after = Instant.now();
        Duration.between(now, after).toMillis();

    }

    public static int process() {
        System.out.println("calculating...");
        return 42;
    }

    public static void runWithLogging(Runnable runnable) {
        System.out.println("Entering method");
        runnable.run();
        System.out.println("Exiting method");
    }

    // public static costam timed(costam)
    // loguje czas wywolania metody
    // zwraca oryginalny rezultat metody
}
