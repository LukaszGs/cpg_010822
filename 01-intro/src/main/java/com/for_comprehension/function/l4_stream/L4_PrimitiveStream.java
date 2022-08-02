package com.for_comprehension.function.l4_stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L4_PrimitiveStream {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
            .mapToInt(i -> i)
            .boxed()
            .forEach(i -> {
            });

        IntStream.range(0, 10).forEach(System.out::println);

        boolean b = List.of(List.of(false, false), List.of(true, true)).stream()
            .flatMap(Collection::stream)
            .anyMatch(result -> result);
    }

}
