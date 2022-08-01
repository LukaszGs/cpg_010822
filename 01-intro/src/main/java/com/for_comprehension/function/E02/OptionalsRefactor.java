package com.for_comprehension.function.E02;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.Optional;

class OptionalsRefactor {

    private Optional<Person> findPerson(int id) {
        var map = Map.of(
            1, new Person("James", 48, 193, LocalDate.of(2000, Month.NOVEMBER, 1)),
            2, new Person("John", 62, 169, LocalDate.of(1989, Month.OCTOBER, 21)));
        return Optional.ofNullable(map.get(id));
    }

    private Optional<String> findAddress(Person person) {
        return Optional.ofNullable(person)
            .filter(p -> p.getBirthDate().isAfter(LocalDate.of(1980, Month.JANUARY, 1)))
            .map(p -> " Some St.   ");
    }

    private Optional<String> findAddressById(int id) {
        return findPerson(id)
            .filter(p -> p.getHeight() > 168)
            .flatMap(this::findAddress)
            .filter(a -> !a.isEmpty())
            .map(String::trim);
   /*
        final Person personOrNull = findPerson(id);
        if (personOrNull != null) {
            if (personOrNull.getHeight() > 168) {
                final String addressOrNull = findAddress(personOrNull);
                if (addressOrNull != null && !addressOrNull.isEmpty()) {
                    return addressOrNull.trim();
                } else {
                    return null;
                }
            }
        }
        return null;*/
    }


    // ***
    // DON"T CHANGE ANYTHING BEYOND THIS POINT
    // ***

    public static class Person {
        private final String name;
        private final int weight;
        private final int height;
        private final LocalDate birthDate;

        public  Person(String name, int weight, int height, LocalDate birthDate) {
            this.name = name;
            this.weight = weight;
            this.height = height;
            this.birthDate = birthDate;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }
    }
}
