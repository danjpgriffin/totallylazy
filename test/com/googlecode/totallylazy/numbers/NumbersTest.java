package com.googlecode.totallylazy.numbers;

import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;
import com.googlecode.totallylazy.functions.TimeReport;
import com.googlecode.totallylazy.matchers.NumberMatcher;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import static com.googlecode.totallylazy.Sequences.repeat;
import static com.googlecode.totallylazy.Sequences.sequence;
import static com.googlecode.totallylazy.functions.Time0.time;
import static com.googlecode.totallylazy.matchers.NumberMatcher.hasExactly;
import static com.googlecode.totallylazy.matchers.NumberMatcher.lessThan;
import static com.googlecode.totallylazy.matchers.NumberMatcher.startsWith;
import static com.googlecode.totallylazy.numbers.BigIntegerOperators.bigInteger;
import static com.googlecode.totallylazy.numbers.Numbers.NEGATIVE_INFINITY;
import static com.googlecode.totallylazy.numbers.Numbers.POSITIVE_INFINITY;
import static com.googlecode.totallylazy.numbers.Numbers.average;
import static com.googlecode.totallylazy.numbers.Numbers.descending;
import static com.googlecode.totallylazy.numbers.Numbers.divide;
import static com.googlecode.totallylazy.numbers.Numbers.fibonacci;
import static com.googlecode.totallylazy.numbers.Numbers.gcd;
import static com.googlecode.totallylazy.numbers.Numbers.lcm;
import static com.googlecode.totallylazy.numbers.Numbers.maximum;
import static com.googlecode.totallylazy.numbers.Numbers.minimum;
import static com.googlecode.totallylazy.numbers.Numbers.multiply;
import static com.googlecode.totallylazy.numbers.Numbers.numbers;
import static com.googlecode.totallylazy.numbers.Numbers.powersOf;
import static com.googlecode.totallylazy.numbers.Numbers.primeFactors;
import static com.googlecode.totallylazy.numbers.Numbers.primes;
import static com.googlecode.totallylazy.numbers.Numbers.probablePrimes;
import static com.googlecode.totallylazy.numbers.Numbers.product;
import static com.googlecode.totallylazy.numbers.Numbers.range;
import static com.googlecode.totallylazy.numbers.Numbers.sumIterable;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;

public class NumbersTest {
    @Test
    public void supportsNum() throws Exception {
        assertThat(Numbers.add(Num.num(3), Num.num(3)), NumberMatcher.is(6));
    }

    @Test
    public void supportsAverage() throws Exception {
        assertThat(numbers(1, 2, 3, 4).reduce(average), NumberMatcher.is(divide(5, 2)));
        assertThat(numbers(1, 2, 3).reduce(average), NumberMatcher.is(2));
        assertThat(numbers(1, 2).reduce(average), NumberMatcher.is(1.5));
        assertThat(numbers(1, 0).reduce(average), NumberMatcher.is(.5));
        assertThat(numbers(1).reduce(average), NumberMatcher.is(1));
        assertThat(numbers().reduce(average), NumberMatcher.is(0));
    }

    @Test
    public void supportsMinimum() throws Exception {
        assertThat(numbers(2,1,null).reduce(minimum), NumberMatcher.is(1));
        assertThat(numbers(null,1,null).reduce(minimum), NumberMatcher.is(1));
        assertThat(numbers(2,1,3).reduce(minimum), NumberMatcher.is(1));
        assertThat(numbers(2,1).reduce(minimum), NumberMatcher.is(1));
        assertThat(numbers(1).reduce(minimum), NumberMatcher.is(1));
        assertThat(numbers().reduce(minimum), NumberMatcher.is(POSITIVE_INFINITY));
        assertSame(minimum, minimum());
    }

    @Test
    public void supportsMaximum() throws Exception {
        assertThat(numbers(2,1,null).reduce(maximum), NumberMatcher.is(2));
        assertThat(numbers(null,1,null).reduce(maximum), NumberMatcher.is(1));
        assertThat(numbers(2,1,3).reduce(maximum), NumberMatcher.is(3));
        assertThat(numbers(2,1).reduce(maximum), NumberMatcher.is(2));
        assertThat(numbers(1).reduce(maximum), NumberMatcher.is(1));
        assertThat(numbers().reduce(maximum), NumberMatcher.is(NEGATIVE_INFINITY));
        assertSame(maximum, maximum());
    }

    @Test
    public void gcdOfEmptyListIsZero() throws Exception {
        assertThat(numbers().reduce(gcd), NumberMatcher.is(0));
    }

    @Test
    public void lcmOfEmptyListIsOne() throws Exception {
        assertThat(numbers().reduce(lcm), NumberMatcher.is(1));
    }

    @Test
    public void productOfEmptyListIsOne() throws Exception {
        assertThat(numbers().reduce(product), NumberMatcher.is(1));
    }

    @Test
    public void supportLcmOnIntegrals() throws Exception {
        assertThat(lcm(3, 5), NumberMatcher.is(15));
        assertThat(lcm(3L, 5L), NumberMatcher.is(15L));
        assertThat(lcm(bigInteger(3), bigInteger(5)), NumberMatcher.is(bigInteger(15)));
    }

    @Test
    public void supportGcdOnIntegrals() throws Exception {
        assertThat(gcd(54, 24), NumberMatcher.is(6));
        assertThat(gcd(54L, 24L), NumberMatcher.is(6L));
        assertThat(gcd(bigInteger(54), bigInteger(24)), NumberMatcher.is(bigInteger(6)));
    }

    @Test
    public void supportsDivide() throws Exception {
        assertThat(sequence(200, 400, 600).map(divide(100)), hasExactly(2, 4, 6));
    }

    @Test
    public void supportsMultiply() throws Exception {
        assertThat(sequence(2, 4, 6).map(multiply(100)), hasExactly(200, 400, 600));
    }

    @Test
    public void supportsRange() throws Exception {
        assertThat(range(0), startsWith(0, 1, 2, 3, 4, 5, 6));
        assertThat(range(1, 5), hasExactly(1, 2, 3, 4, 5));
        assertThat(range(5, 1), hasExactly(5, 4, 3, 2, 1));
        assertThat(range(0, 4, 2), hasExactly(0, 2, 4));
        assertThat(range(4, 0, -2), hasExactly(4, 2, 0));
    }

    @Test
    public void supportsRangeUsesAbsoluteStepValue() throws Exception {
        assertThat(range(0, 4, -2), hasExactly(0, 2, 4));
        assertThat(range(4, 0, 2), hasExactly(4, 2, 0));
    }

    @Test
    public void supportsSorting() throws Exception {
        assertThat(numbers(5d, 1, 4L, bigInteger(2), 3f).sortBy(descending()), hasExactly(5d, 4L, 3f, bigInteger(2), 1));
    }

    @Test
    public void supportsProduct() throws Exception {
        assertThat(sequence(1, 2, 3).reduce(product()), NumberMatcher.is(6));
    }

    @Test
    @Ignore("Manual Performance Test")
    public void shouldBePrettyFast() throws Exception {
        TimeReport report = new TimeReport();
        repeat(time(sumIterable(), range(0, 10000), report)).take(100).realise();
        System.out.println(report);
        assertThat(report.average(), is(lessThan(20)));
    }

    @Test
    public void toStringingAnInfiniteListWillTruncateByDefault() throws Exception {
        assertThat(primes().toString(), is(primes().take(100).toString()));
    }

    @Test
    public void supportsPrimeFactorsOfLargeNumbers() throws Exception {
        assertThat(primeFactors(600851475143L), hasExactly(71, 839, 1471, 6857));
    }

    @Test
    @Ignore("Manual Performance Test")
    public void primeFactorsOfLargeNumbersIsPrettyFast() throws Exception {
        TimeReport report = TimeReport.time(100, primeFactors(600851475143L));
        System.out.println(report);
        assertThat(report.maximum(), is(lessThan(20.0)));
        assertThat(report.average(), is(lessThan(1.0)));
    }

    @Test
    public void supportsPrimeFactors() throws Exception {
        assertThat(primeFactors(13195), hasExactly(5, 7, 13, 29));
    }

    @Test
    public void supportsPrimeFactorsOfSmallNumbers() throws Exception {
        assertThat(primeFactors(300), hasExactly(2, 3, 5));
    }

    @Test
    public void supportsPrimes() throws Exception {
        assertThat(primes(), startsWith(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
    }

    @Test
    public void supportsProbablePrimes() throws Exception {
        assertThat(probablePrimes(), startsWith(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
    }

    @Test
    @Ignore("Manual Performance Test")
    public void primesIsPrettyFastAndIsMemorised() throws Exception {
        TimeReport report = TimeReport.time(1000, primes().take(1000));
        System.out.println(report);
        assertThat(report.average(), Matchers.is(lessThan(10.0)));
    }

    @Test
    public void supportsFibonacci() throws Exception {
        assertThat(fibonacci(), startsWith(0, 1, 1, 2, 3, 5));
    }

    @Test
    public void supportsPowersOf() throws Exception {
        assertThat(powersOf(2), startsWith(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048));
        assertThat(powersOf(3), startsWith(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049));
        assertThat(powersOf(10), startsWith(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L));
    }

    @Test
    public void supportsStringToNumberConversion() throws Exception {
        assertThat(Numbers.valueOf("1").get().intValue(), is(1));
        assertThat(Numbers.valueOf("1.11").get().doubleValue(), is(1.11d));
        assertThat(Numbers.valueOf("-1.11").get().doubleValue(), is(-1.11d));
        assertThat(Numbers.valueOf("").isEmpty(), is(true));
        assertThat(Numbers.valueOf(null).isEmpty(), is(true));
    }

    /**
     * Test case for issue #14
     */
    @Test
    public void supportsShort() {
        assertThat(numbers((short)0, (short)0 ,(short)1).reduceLeft(Numbers.maximum), NumberMatcher.is((short) 1));

        Sequence<Short> s = Sequences.sequence((short)0, (short)0 ,(short)1);
        Number result = s.reduceLeft(Numbers.maximum());
        assertEquals(Short.class, result.getClass());
        assertThat(result, NumberMatcher.is(Short.valueOf((short) 1)));
    }
}
