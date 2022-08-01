package com.for_comprehension.function;

class HelloWorld {

    public static void main(String[] args) {

    }

    public static void process(Runnable runnable) {
        System.out.println("before running");
        runnable.run();
        System.out.println("after running");
    }



}
