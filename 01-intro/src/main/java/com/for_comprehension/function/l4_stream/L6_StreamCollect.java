package com.for_comprehension.function.l4_stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L6_StreamCollect {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());
        Set<Integer> set = Stream.of(1, 2, 3).collect(Collectors.toSet());
        LinkedList<Integer> ll = Stream.of(1, 2, 3).collect(Collectors.toCollection(LinkedList::new));
        ArrayList<Integer> al = Stream.of(1, 2, 3).collect(Collectors.toCollection(ArrayList::new));


    }

}
