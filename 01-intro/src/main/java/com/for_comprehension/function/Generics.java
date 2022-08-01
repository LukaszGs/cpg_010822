package com.for_comprehension.function;

import java.util.Arrays;
import java.util.Collection;

public class Generics {

    public static void main(String[] args) {
    }

    public static <T, B extends Thread> T foo(Collection<B> object, T defaultValue) {
        return defaultValue;
    }

}
