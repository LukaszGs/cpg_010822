package com.for_comprehension.function.l4_stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class L3_StreamAPI {

    public static void main(String[] args) {
        // get ANY element of a stream
        Optional<Integer> any = Stream.of(1, 2, 3)
            .findAny();

        // get FIRST(according to ordering) element of a stream
        Optional<Integer> first = Stream.of(1, 2, 3)
            .findFirst();

        // perform for EVERY element
        Stream.of(1, 2, 3)
            .forEach(System.out::println);

        // sorted according to a provided comparator
        Stream.of("a", "ccc", "bb")
            .sorted(Comparator.comparing(String::length))
            .forEach(System.out::println);

        // remove duplicates
        Stream.of(1, 2, 3, 3)
            .distinct()
            .forEach(System.out::println);

        // skip one element and take only one element
        Stream.of("a", "ccc", "bb")
            .skip(1)
            .limit(1)
            .forEach(System.out::println);

        // drop/take conditionally
        Stream.of("a", "ccc", "bb")
            .dropWhile(i -> i.length() < 2)
            .takeWhile(s -> s.length() > 1)
            .forEach(System.out::println);

        // count all stream elements
        long count = Stream.of(1, 2, 3, 3)
            .count();

        // reduce with an initial elements
        Integer reduce = Stream.of(1, 2, 3)
            .reduce(1, Integer::sum);

        // reduce without an initial elements
        Optional<Integer> reduce2 = Stream.of(1, 2, 3)
            .reduce(Integer::sum);

        boolean b1 = Stream.of(1, 2, 3).allMatch(i -> i > 0);
        boolean b2 = Stream.of(1, 2, 3).anyMatch(i -> i > 2);
        boolean b3 = Stream.of(1, 2, 3).noneMatch(i -> i > 0);

        // truth table for empty streams
        System.out.println(Stream.<Integer>of().allMatch(i -> i > 0));
        System.out.println(Stream.<Integer>of().anyMatch(i -> i > 0));
        System.out.println(Stream.<Integer>of().noneMatch(i -> i > 0));

    }

}
