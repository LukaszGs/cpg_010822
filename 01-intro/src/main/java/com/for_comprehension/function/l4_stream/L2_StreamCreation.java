package com.for_comprehension.function.l4_stream;

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class L2_StreamCreation {

    public static void main(String[] args) {
        // 0
        Collection<Integer> integers = List.of(1);
        Stream<Integer> stream1 = integers.stream();

        // 1
        Stream<Integer> stream = Stream.of(1, 2, 3);

        // 2
        Stream<Integer> infinite = Stream.generate(() -> 42);

        // 3
        Stream<Integer> infinite2 = Stream.iterate(0, i -> i + 1);
        Stream<Integer> bounded = Stream.iterate(0, i -> i < 50, i -> i + 1);

        // 4
        Stream<Object> nullable = Stream.ofNullable(null);

        // 5
        Stream<Integer> concat = Stream.concat(Stream.of(1), Stream.of(2, 3));
    }

}
