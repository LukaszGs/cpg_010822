package com.for_comprehension.function.l2_optional;

import java.util.Optional;

public class CreatingOptional {

    public static void main(String[] args) {
        Optional<String> s = Optional.ofNullable("");
        Optional<String> s2 = Optional.of("");
    }

    // no point in using ofNullable because the user is always there
    public static class FixedUserRepository implements UserRepository {

        @Override
        public Optional<String> find() {
            return Optional.of("Adam");
        }
    }

    interface UserRepository {
        Optional<String> find();
    }
}
