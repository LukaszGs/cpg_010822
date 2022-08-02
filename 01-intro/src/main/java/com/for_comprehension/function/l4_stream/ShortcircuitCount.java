package com.for_comprehension.function.l4_stream;

import java.util.Arrays;
import java.util.List;

public class ShortcircuitCount {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        long count = integers.stream()
            .map(i -> i + 1)
            .map(i -> {
                System.out.println("HTTP request");
                return i;
            })
//            .filter(i -> true)
            .count();

        System.out.println(count);

    }

}
