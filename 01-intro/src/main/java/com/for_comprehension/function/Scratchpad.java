package com.for_comprehension.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scratchpad {

    public static void main(String[] args) {

        Map<String, String> foo = Map.of("foo", "bar");

        foo.entrySet().stream()
            .forEach(System.out::println);

    }
}
