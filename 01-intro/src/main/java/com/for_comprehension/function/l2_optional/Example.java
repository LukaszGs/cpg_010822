package com.for_comprehension.function.l2_optional;

import java.util.Optional;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Example {

    public static void main(String[] args) {

    }

    public static Optional<Integer> getNumber() {
        return Optional.of(1);
    }

    public static boolean getOptional() {
        return getNumber()
            .map(i -> i > 10)
            .filter(i -> i)
            .orElseGet(() -> current().nextInt() > 1000 || current().nextInt() < 10);
    }

    public static boolean getImperative() {
        Optional<Integer> optional = getNumber();
        if (optional.isPresent()) {
            Integer integer = optional.get();
            if (integer > 10) {
                return true;
            }
            else {
                if (current().nextInt() > 1000) {
                    return true;
                }
                else {
                    return current().nextInt() < 10;
                }
            }
        }

        return false;
    }

}
