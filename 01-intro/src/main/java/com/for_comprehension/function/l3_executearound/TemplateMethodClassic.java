package com.for_comprehension.function.l3_executearound;

public class TemplateMethodClassic {

    public static void main(String[] args) {
        /*System.out.println("Entering method");
        process();
        System.out.println("Exiting method");*/

        new ProcessWithLogging().run();
    }

    public static void process() {
        System.out.println("calculating...");
    }

    public static class ProcessWithLogging extends SurroundWithLogging {

        @Override
        void runInternal() {
            process();
        }

    }


    public static abstract class SurroundWithLogging {
        void run() {
            System.out.println("Entering method");
            runInternal();
            System.out.println("Exiting method");
        }
        abstract void runInternal();
    }


}
