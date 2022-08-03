package com.for_comprehension.function.l5_threads;

public class L1_Basics {

    public static void main(String[] args) {

        ValueHolder valueHolder = new ValueHolder();

        var t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    break;
                }

                valueHolder.print();
            }
        });
        t1.start();

        var t2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    break;
                }

                valueHolder.modify();
            }
        });
        t2.start();

        var t3 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    break;
                }

                valueHolder.modify();
            }
        });

        t3.start();

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                return;
            }

            t3.interrupt();
            t2.interrupt();
            t1.interrupt();
        }).start();
    }

    public static class ValueHolder {

        private volatile String a = "a";

        private volatile String b = "b";

        public synchronized void modify() {
            var tempa = a;
            var tempb = b;

            a = "that should not be here!";
            simulateLag(1000);
            b = "that should not be here!";

            a = tempa;
            b = tempb;
        }

        private static void simulateLag(int millis) {
            try {
                Thread.sleep(millis);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public synchronized void print() {
            System.out.println("a=" + a);
            System.out.println("b=" + b);
        }

    }

}
