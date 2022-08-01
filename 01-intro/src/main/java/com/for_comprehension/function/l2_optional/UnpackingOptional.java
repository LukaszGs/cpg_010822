package com.for_comprehension.function.l2_optional;

import java.util.Optional;

public class UnpackingOptional {

    public static void main(String[] args) {

        HelloOptional.User adam = findById(42).orElse(new HelloOptional.User("Adam", 10));
        HelloOptional.User lazyAdam = findById(42).orElseGet(() -> new HelloOptional.User("Adam", 10));

        HelloOptional.User userOrEx = findById(42).get(); // get or throw
        HelloOptional.User userOrEx2 = findById(42).orElseThrow(); // get or throw

        HelloOptional.User userOrEx3 = findById(42).orElseThrow(IllegalArgumentException::new); // get or throw

        findById(42).ifPresent(System.out::println);
        findById(42).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("empty!"));

        Optional<HelloOptional.User> or = findById(42).or(() -> findById(1));
    }

    public static Optional<HelloOptional.User> findById(int id) {
        if (id == 12) {
            return Optional.of(new HelloOptional.User("John", 42));
        }

        return Optional.empty();
    }

}
