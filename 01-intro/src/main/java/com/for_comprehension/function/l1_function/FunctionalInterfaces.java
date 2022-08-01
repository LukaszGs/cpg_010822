package com.for_comprehension.function.l1_function;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Function<String, Integer> f1 = str -> Integer.parseInt(str);
        Supplier<Integer> f2 = () -> 42;                      // Function<Void, Integer>
        Consumer<Integer> f3 = foo -> System.out.println(foo);// Function<Integer, Void>
        Predicate<Integer> f4 = integer -> true;              // Function<Integer, Boolean>

        UnaryOperator<Integer> f5 = i -> i + 1;               // Function<Integer, Integer>
        BinaryOperator<Integer> f6 = (i1, i2) -> i1;          // BiFunction<Integer, Integer, Integer>

        Runnable runnable = () -> {
        };                         // Function<Void, Void>
        Callable<Integer> callable = () -> 42;                // Supplier<Integer>

        TernaryFunction<Integer, Integer, Integer, Integer> ternary = (i1, i2, i3) -> i1 + i2 + i3;

        int foo = 4;
        Integer foo2 = 4;

        // function composition

        Function<Integer, Integer> add = i -> i + 2;
        Function<Integer, Integer> multiply = i -> i * 2;

        Function<Integer, Integer> integerIntegerFunction = add.andThen(multiply);

        System.out.println(integerIntegerFunction.apply(1));

    }

    @FunctionalInterface
    interface TernaryFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
        default R applyWithLogging(T1 t1, T2 t2, T3 t3) {
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
            return apply(t1, t2, t3);
        }
    }

}
