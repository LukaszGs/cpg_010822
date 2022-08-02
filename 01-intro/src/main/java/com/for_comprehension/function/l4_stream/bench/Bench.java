package com.for_comprehension.function.l4_stream.bench;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import static java.util.stream.Collectors.toList;

public class Bench {

    private static final List<Integer> source = IntStream.range(0, 1000)
        .boxed()
        .collect(toList());

    @Benchmark
    public Optional<Integer> stream() {
        return source.stream()
            .map(i -> i + 1)
            .map(i -> i + 2)
            .map(i -> i + 3)
            .map(i -> i + 4)
            .filter(i -> i > 50)
            .findAny();
    }

    /*
    Benchmark             Mode   Cnt        Score       Error  Units
    Bench.loop            thrpt    5   3234986.933 ± 51968.817  ops/s
    Bench.stream          thrpt    5    683683.097 ± 15803.855  ops/s
    Bench.loop_primitive  thrpt    5  26514405.541 ± 283016.260  ops/s
*/

    @Benchmark
    public Optional<Integer> loop() {
        for (Integer i : source) {
            Integer integer = i + 1;
            Integer i1 = integer + 2;
            Integer integer1 = i1 + 3;
            Integer i2 = integer1 + 4;
            if (i2 > 50) {
                return Optional.of(i2);
            }
        }
        return Optional.empty();
    }

    @Benchmark
    public int loop_primitive() {
        for (int i : source) {
            int integer = i + 1;
            int i1 = integer + 2;
            int integer1 = i1 + 3;
            int i2 = integer1 + 4;
            if (i2 > 50) {
                return i2;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(
            new OptionsBuilder()
                .include(Bench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build()).run();
    }

}
