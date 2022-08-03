package com.for_comprehension.function.l4_stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L5_Parallel {

    public static void main(String[] args) {
        List<Object> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
            .parallel()
            .map(i -> process(i))
            .collect(Collectors.toList());

        System.out.println(collect);

    }

    private static Integer process(Integer i) {
        System.out.println("processing... " + i);
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
        }
        return i;
    }

}
