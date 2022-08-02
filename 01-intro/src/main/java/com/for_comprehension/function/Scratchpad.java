package com.for_comprehension.function;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scratchpad {

    public static void main(String[] args) {
        Stream.of(List.of(1), List.of(2, 3))
            .flatMap(list -> list.stream())
            .collect(Collectors.toList());

        Stream.of(Optional.of(1),Optional.of(2), Optional.empty())
            .flatMap(optional -> optional.stream())
            .collect(Collectors.toList());

    }

}
