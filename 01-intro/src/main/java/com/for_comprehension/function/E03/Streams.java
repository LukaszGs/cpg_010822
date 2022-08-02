package com.for_comprehension.function.E03;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streams {

    private static void L0_cubeComposer() {
        // https://david-peter.de/cube-composer/
    }

    /**
     * Uppercase all strings in a list {@link Stream#map(Function)}
     */
    static Function<List<String>, List<String>> L1_upperCaseAll() {
        return strings -> strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    /**
     * Uppercase all list elements and discard names containing less than 6 characters
     * {@link Stream#filter(Predicate)}
     */
    static Function<List<String>, List<String>> L2_upperCaseAllAndFilter() {
        return strings -> strings.stream()
            .filter(name -> name.length() > 5)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    /**
     * Find the longest name {@link Stream#max(Comparator)} {@link Stream#sorted()} {@link Stream#findAny()}
     */
    static Function<List<String>, String> L3_findTheLongestName() {
        return strings -> strings.stream()
            .max(Comparator.comparingInt(String::length))
            .orElseThrow();
    }

    /**
     * Flatten a nested list structure {@link Stream#flatMap(Function)}
     */

    // [[1,2], [3], []] -> [1,2,3]
    static Function<List<List<Integer>>, List<Integer>> L4_flatten() {
        return lists -> lists.stream()
            .flatMap(Collection::stream)
            //            .flatMap(list -> list.stream())
            .collect(Collectors.toList());
    }

    /**
     * Eliminate duplicates {@link Stream#distinct()}
     */
    static Function<List<Integer>, List<Integer>> L5_distinctElements() {
        return list -> list.stream()
            .distinct()
            .collect(Collectors.toList());
    }

    /**
     * Duplicate the elements of a list
     */
    static Function<List<Integer>, List<Integer>> L6_duplicateElements() {
        return integers -> integers.stream()
            .flatMap(e -> Stream.of(e, e))
            // .flatMap(e -> Stream.generate(() -> e).limit(2))
            .collect(Collectors.toList());
    }

    /**
     * Duplicate the elements of a list a given number of times {@link Stream#generate(Supplier)}
     */
    static Function<List<Integer>, List<Integer>> L7_duplicateElementsNTimes(int givenNumberOfTimes) {
        return integers -> integers.stream()
            .flatMap(e -> Stream.generate(() -> e).limit(givenNumberOfTimes))
            .collect(Collectors.toList());
    }

    /**
     * Create a stream only with multiples of 3, starting from 0, size of 10 {@link Stream#iterate}
     */
    static Supplier<List<Integer>> L8_generate3s() {
        return () -> Stream.iterate(1, i -> i + 3)
            .limit(10)
            .collect(Collectors.toList());
    }

    /**
     * Find five consecutive leap years since 2000 {@link Stream#iterate(Object, UnaryOperator)}
     * {@link LocalDate#isLeapYear()}
     */
    static Supplier<List<Integer>> L9_leapYears() {
        return () -> Stream.iterate(Year.of(2000), year -> year.plusYears(1))
            .filter(year -> year.isLeap())
            .limit(5)
            .map(year -> year.getValue())
            .collect(Collectors.toList());

    }

    /**
     * Rotate a list N places to the left {@link Stream#concat(Stream, Stream)} {@link Stream#skip(long)}
     * {@link Stream#limit(long)}
     */
    // [1,2,3,4] -> [2,3,4,1] -> [3,4,1,2] -> [4,1,2,3] -> [1,2,3,4]
    // [1,2,3,4,1,2,3,4]
    static UnaryOperator<List<Integer>> L10_rotate(int n) {
        return integers -> {
            if (integers.isEmpty()) {
                return Collections.emptyList();
            }

            if (n % integers.size() == 0) {
                return List.copyOf(integers);
            }

            return Stream.concat(integers.stream(), integers.stream())
                .skip(n % integers.size())
                .limit(integers.size())
                .collect(Collectors.toUnmodifiableList());
        };

    }

    /**
     * Check if all elements sum up to 100, if no throw an exception
     */
    static Predicate<List<Double>> L11_sum() throws IllegalStateException {
        return doubles -> doubles.stream()
            .reduce(Double::sum)
            //            .flatMap(sum -> sum == 100 ? Optional.of(true) : Optional.empty())
            .map(sum -> sum == 100)
            .filter(result -> result)
            .orElseThrow(IllegalStateException::new);

    }

    /**
     * Convert a {@link List} of {@link java.util.Optional} to a {@link List} of only not-empty values
     *
     * Advanced challenge: use {@link Stream#flatMap(Function)}
     */
    static Function<List<Optional<Integer>>, List<Integer>> L12_filterPresent() {
        return optionals -> optionals.stream()
            .flatMap(Optional::stream)
            //.flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))

            //            .filter(Optional::isPresent)
            //            .map(Optional::get)
            .collect(Collectors.toList());

    }

}
