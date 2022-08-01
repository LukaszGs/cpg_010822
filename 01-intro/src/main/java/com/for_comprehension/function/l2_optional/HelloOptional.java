package com.for_comprehension.function.l2_optional;

import java.util.Map;
import java.util.Optional;

public class HelloOptional {

    public static void monad1(String[] args) {
        Map<String, Integer> foo = Map.of("foo", 42);

        Optional<Integer> optionalInt = Optional.ofNullable(foo.get("foo"));
        Optional<Integer> optionalIntIncremented = optionalInt.map(i -> i + 1);
        Optional<Integer> optionalIntDuplicated = optionalIntIncremented.map(i -> i * 2);
        Optional<String> asString = optionalIntDuplicated.map(i -> String.valueOf(i));
        String result = asString.orElse("default");

    }

    public static void main(String[] args) {
        Map<String, Integer> foo = Map.of("foo", 42);

        String result = Optional.ofNullable(foo.get("foo2"))
            .map(i -> i + 1)
            .map(i -> i * 2)
            .map(String::valueOf)
            .orElse("default");

        System.out.println(result);
    }

}
