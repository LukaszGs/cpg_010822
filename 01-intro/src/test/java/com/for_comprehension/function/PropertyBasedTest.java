package com.for_comprehension.function;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.Encoded;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(JUnitQuickcheck.class)
public class PropertyBasedTest {

    @Property(trials = 100)
    public void shouldNotDivideByZero(long input) {
        assertThatThrownBy(() -> {
            var a = (input / 0);
        }).isInstanceOf(Exception.class);
    }

    @Property(trials = 100)
    public void upperCasedStringHasSameLength(@Encoded.InCharset("US-ASCII") String input) {
        Assertions.assertThat(input.length()).isEqualTo(input.toUpperCase().length());
    }

    @Property(trials = 100)
    public void concatenatedStringHasSameLenghAsSumOfLengths(@Encoded.InCharset("US-ASCII") String a, @Encoded.InCharset("US-ASCII") String b) {
        Assertions.assertThat(a.length() + b.length()).isEqualTo((a + b).length());
    }

}
