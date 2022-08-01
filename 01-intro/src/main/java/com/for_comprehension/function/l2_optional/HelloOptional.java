package com.for_comprehension.function.l2_optional;

import java.util.Optional;

public class HelloOptional {

    public static void main(String[] args) {
        // String user = findById(42) doesn't compile
        Optional<User> user = findById(42);

        String result = findById(12)
            .map(User::getAge)
            .filter(age -> age > 40)
            .map(age -> "Age: " + age)
            .orElseGet(() -> getDefaultAge());

        System.out.println(result);
    }

    public static void main2(String[] args) {
        // String user = findById(42) doesn't compile
        Optional<User> user = findById(42);

        Optional<String> user1 = findById(12)
//            .flatMap(u -> Optional.ofNullable(""))
            .map(u -> "");
    }

    public static String getDefaultAge() {
        try {
            System.out.println("calculating default age...");
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Default age";
    }

    public static Optional<User> findById(int id) {
        if (id == 12) {
            return Optional.of(new User("John", 42));
        }

        return Optional.empty();
    }

    public static class User {
        private final String name;
        private final Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

}
