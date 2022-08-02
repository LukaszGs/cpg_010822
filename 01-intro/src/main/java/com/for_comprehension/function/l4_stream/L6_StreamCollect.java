package com.for_comprehension.function.l4_stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L6_StreamCollect {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());
        Set<Integer> set = Stream.of(1, 2, 3).collect(Collectors.toSet());
        LinkedList<Integer> ll = Stream.of(1, 2, 3).collect(Collectors.toCollection(LinkedList::new));
        ArrayList<Integer> al = Stream.of(1, 2, 3).collect(Collectors.toCollection(ArrayList::new));

        Map<String, Integer> map = Stream.of("dddddd", "a", "bb", "ccc", "ccc")
            .collect(Collectors.toMap(str -> str, String::length, (length1, length2) -> length1,
                TreeMap::new));

        Map<Integer, List<String>> collect = Stream.of("dddddd", "a", "bb", "ccc", "ccc")
            .collect(Collectors.groupingBy(str -> str.length(), TreeMap::new, Collectors.mapping(i -> i.toUpperCase(), Collectors.toList())));

        String joined = Stream.of("dddddd", "a", "bb", "ccc", "ccc")
            .collect(Collectors.joining(",", "[", "]"));

        Stream.of("dddddd", "a", "bb", "ccc", "ccc")
                .collect(Collectors.collectingAndThen(
                    Collectors.toList(),
                    LinkedList::new));

        System.out.println(joined);

    }

}
