package com.for_comprehension.function.l4_stream;

import java.util.stream.Stream;

public class L1_Stream {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);

        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

}
