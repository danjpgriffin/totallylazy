/*
This code is a a heavily modified version of Numbers from Rich Hickeys clojure core
 */

/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Mar 31, 2008 */


package com.googlecode.totallylazy.numbers;

import com.googlecode.totallylazy.functions.CurriedBinary;
import com.googlecode.totallylazy.functions.Function1;
import com.googlecode.totallylazy.functions.CurriedMonoid;
import com.googlecode.totallylazy.Computation;
import com.googlecode.totallylazy.Option;
import com.googlecode.totallylazy.Pair;
import com.googlecode.totallylazy.predicates.Predicate;
import com.googlecode.totallylazy.predicates.Predicates;
import com.googlecode.totallylazy.Segment;
import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;
import com.googlecode.totallylazy.functions.Unary;
import com.googlecode.totallylazy.Unchecked;
import com.googlecode.totallylazy.predicates.LogicalPredicate;
import com.googlecode.totallylazy.predicates.RemainderIs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Iterator;

import static com.googlecode.totallylazy.functions.Callables.first;
import static com.googlecode.totallylazy.Computation.computation;
import static com.googlecode.totallylazy.Option.none;
import static com.googlecode.totallylazy.Option.some;
import static com.googlecode.totallylazy.Pair.reduceLeftShift;
import static com.googlecode.totallylazy.predicates.Predicates.is;
import static com.googlecode.totallylazy.Segment.constructors.segment;
import static com.googlecode.totallylazy.Segment.constructors.unique;
import static com.googlecode.totallylazy.Sequences.characters;
import static com.googlecode.totallylazy.Sequences.iterate;
import static com.googlecode.totallylazy.Sequences.repeat;
import static com.googlecode.totallylazy.predicates.WherePredicate.where;

public class Numbers {
    public static final Number POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final Number NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final ArithmeticException DIVIDE_BY_ZERO = new ArithmeticException("Divide by zero");
    public static Function1<Number, Integer> intValue = Number::intValue;

    public static Sequence<Number> range(final Number start) {
        return iterate(increment, start);
    }

    public static Sequence<Number> range(final Number start, final Number end) {
        if (lessThan(end, start)) return range(start, end, 1);
        return range(start).takeWhile(lessThanOrEqualTo(end));
    }

    public static Sequence<Number> range(final Number start, final Number end, final Number step) {
        Number absoluteStep = Numbers.absolute(step);
        if (lessThan(end, start)) return iterate(subtract(absoluteStep), start).takeWhile(greaterThanOrEqualTo(end));
        return iterate(add(absoluteStep), start).takeWhile(lessThanOrEqualTo(end));
    }

    public static Number absolute(Number number) {
        return operatorsFor(number.getClass()).absolute(number);
    }

    public static Option<Number> valueOf(String string) {
        try {
            return some(reduce(new BigDecimal(string)));
        } catch (Exception e) {
            return none(Number.class);
        }
    }

    public static Function1<Object, Number> valueOf = value -> Numbers.valueOf(value.toString()).get();

    public static Sequence<Number> numbers(Number... numbers) {
        return Sequences.sequence(numbers);
    }

    public static Sequence<Number> numbers(final int[] numbers) {
        return new Sequence<Number>() {
            public Iterator<Number> iterator() {
                return new IntIterator(numbers);
            }
        };
    }

    public static Sequence<Number> primeFactors(final Number number) {
        return Segment.methods.sequence(factor(primes, number));
    }

    static Segment<Number> factor(Segment<Number> primes, Number number) {
        Number prime = primes.head();
        if (greaterThan(squared(prime), number)) return segment(number);
        if (isZero(remainder(number, prime))) return unique(prime, factor(primes, quotient(number, prime)));
        return factor(primes.tail(), number);
    }

    public static Number squareRoot(Number number) {
        return Math.sqrt(number.doubleValue());
    }

    public static Unary<Number> squareRoot = Numbers::squareRoot;

    public static Unary<Number> squared = Numbers::squared;

    public static Unary<Number> squared() {
        return squared;
    }

    public static Number squared(Number value) {
        return multiply(value, value);
    }

    public static LogicalPredicate<Number> not(Number value) {
        return Predicates.not(value);
    }

    public static LogicalPredicate<Number> not(Predicate<? super Number> predicate) {
        return Predicates.not(predicate);
    }

    public static LogicalPredicate<Number> even = remainderIs(2, 0);

    public static LogicalPredicate<Number> even() {
        return even;
    }

    public static LogicalPredicate<Number> odd = remainderIs(2, 1);

    public static LogicalPredicate<Number> odd() {
        return odd;
    }

    public static LogicalPredicate<Number> prime = new LogicalPredicate<Number>() {
        public final boolean matches(final Number candidate) {
            return isPrime(candidate);
        }
    };

    public static LogicalPredicate<Number> prime() {
        return prime;
    }

    public static LogicalPredicate<Number> isPrime() {
        return prime;
    }

    public static boolean isPrime(Number candidate) {
        return primes().takeWhile(where(squared, lessThanOrEqualTo(candidate))).forAll(where(remainder(candidate), is(not(zero))));
    }

    public static LogicalPredicate<Number> remainderIs(final Number divisor, final Number remainder) {
        return new RemainderIs(divisor, remainder);
    }

    public static Sequence<Number> probablePrimes() {
        return iterate(nextProbablePrime(), BigInteger.valueOf(2)).map(reduce());
    }

    private static Unary<BigInteger> nextProbablePrime() {
        return BigInteger::nextProbablePrime;
    }

    public static Unary<Number> nextPrime = Numbers::nextPrime;

    public static Unary<Number> nextPrime() {
        return nextPrime;
    }

    public static Computation<Number> primes = Computation.cons(2, computation(3, nextPrime));

    public static Sequence<Number> primes() {
        return primes;
    }

    public static Number nextPrime(Number number) {
        return iterate(add(2), number).filter(prime).second();
    }

    public static Sequence<Number> fibonacci() {
        return computation(Pair.<Number, Number>pair(0, 1), reduceLeftShift(sum)).map(first(Number.class));
    }

    public static Sequence<Number> powersOf(Number amount) {
        return Computation.iterate(multiply(amount), 1);
    }

    public static Operators<Number> operatorsFor(Class<? extends Number> numberClass) {
        return Unchecked.cast(internalOperatorsFor(numberClass));
    }

    private static Operators<? extends Number> internalOperatorsFor(Class<? extends Number> numberClass) {
        if (numberClass == Short.class) return ShortOperators.Instance;
        if (numberClass == Integer.class) return IntegerOperators.Instance;
        if (numberClass == Long.class) return LongOperators.Instance;
        if (numberClass == BigInteger.class) return BigIntegerOperators.Instance;
        if (numberClass == BigDecimal.class) return BigDecimalOperators.Instance;
        if (numberClass == Ratio.class) return RatioOperators.Instance;
        if (numberClass == Float.class) return FloatOperators.Instance;
        if (numberClass == Double.class) return DoubleOperators.Instance;
        throw new UnsupportedOperationException("Unsupported number " + numberClass);
    }

    public static Operators<Number> operatorsFor(Number number) {
        if(number instanceof Num) return new NumOperator(operatorsFor(((Num) number).value()));
        return operatorsFor(number.getClass());
    }

    public static Operators<Number> operatorsFor(Number a, Number b) {
        Operators<Number> aOperators = operatorsFor(a);
        Operators<Number> bOperators = operatorsFor(b);

        return aOperators.priority() > bOperators.priority() ? aOperators : bOperators;
    }

    public static Number negate(Number value) {
        return operatorsFor(value).negate(value);
    }

    public static Unary<Number> increment = Numbers::increment;

    public static Unary<Number> increment() {
        return increment;
    }

    public static Number increment(Number value) {
        return operatorsFor(value).increment(value);
    }

    public static Unary<Number> decrement = Numbers::decrement;

    public static Unary<Number> decrement() {
        return decrement;
    }

    public static Number decrement(Number value) {
        return operatorsFor(value).decrement(value);
    }

    public static LogicalPredicate<Number> zero = new LogicalPredicate<Number>() {
        @Override
        public boolean matches(Number other) {
            return isZero(other);
        }
    };

    public static LogicalPredicate<Number> zero() {
        return zero;
    }

    public static LogicalPredicate<Number> isZero = zero;

    public static LogicalPredicate<Number> isZero() {
        return zero;
    }

    public static boolean isZero(Number value) {
        return operatorsFor(value).isZero(value);
    }

    public static boolean isPositive(Number value) {
        return operatorsFor(value).isPositive(value);
    }

    public static boolean isNegative(Number value) {
        return operatorsFor(value).isNegative(value);
    }

    public static boolean equalTo(Number x, Number y) {
        return operatorsFor(x, y).equalTo(x, y);
    }

    public static LogicalPredicate<Number> lessThan(final Number value) {
        return new LessThanPredicate(value);
    }

    public static boolean lessThan(Number x, Number y) {
        return operatorsFor(x, y).lessThan(x, y);
    }

    public static LogicalPredicate<Number> lessThanOrEqualTo(final Number value) {
        return new LessThanOrEqualToPredicate(value);
    }

    public static boolean lessThanOrEqualTo(Number x, Number y) {
        return !operatorsFor(x, y).lessThan(y, x);
    }

    public static LogicalPredicate<Number> greaterThan(final Number value) {
        return new GreaterThanPredicate(value);
    }

    public static boolean greaterThan(Number x, Number y) {
        return operatorsFor(x, y).lessThan(y, x);
    }

    public static LogicalPredicate<Number> greaterThanOrEqualTo(final Number value) {
        return new GreaterThanOrEqualToPredicate(value);
    }

    public static boolean greaterThanOrEqualTo(Number x, Number y) {
        return !operatorsFor(x, y).lessThan(x, y);
    }

    public static LogicalPredicate<Number> between(final Number a, final Number b) {
        return new BetweenPredicate(a, b);
    }

    public static int compare(Number x, Number y) {
        Operators<Number> operators = operatorsFor(x, y);
        if (operators.lessThan(x, y)) return -1;
        if (operators.lessThan(y, x)) return 1;
        return 0;
    }

    public static Comparator<Number> ascending() {
        return Numbers::compare;
    }

    public static Comparator<Number> descending() {
        return (x, y) -> compare(y, x);
    }

    public static Function1<Iterable<Number>, Number> sumIterable() {
        return numbers -> Sequences.reduceLeft(numbers, sum());
    }

    public static final CurriedMonoid<Number> average = new Average();
    public static CurriedMonoid<Number> average() {
        return average;
    }

    public static final CurriedMonoid<Number> sum = new Sum();
    public static final CurriedMonoid<Number> Σ = sum;

    public static CurriedMonoid<Number> sum() {
        return sum;
    }

    public static final CurriedMonoid<Number> add = sum;

    public static CurriedMonoid<Number> add() {
        return add;
    }

    public static Unary<Number> add(final Number amount) {
        return add.apply(amount);
    }

    public static Number add(Number x, Number y) {
        return operatorsFor(x, y).add(x, y);
    }

    public static CurriedBinary<Number> subtract = Numbers::subtract;

    public static CurriedBinary<Number> subtract() {
        return subtract;
    }

    public static Unary<Number> subtract(final Number amount) {
        return subtract.flip().apply(amount);
    }

    public static Number subtract(Number x, Number y) {
        return operatorsFor(x, y).add(x, operatorsFor(y).negate(y));
    }

    public static CurriedMonoid<Number> product = new Product();

    public static CurriedMonoid<Number> product() {
        return product;
    }

    public static CurriedMonoid<Number> multiply = product;

    public static CurriedMonoid<Number> multiply() {
        return multiply;
    }

    public static Unary<Number> multiply(final Number multiplicand) {
        return multiply.apply(multiplicand);
    }

    public static Number multiply(Number x, Number y) {
        return operatorsFor(x, y).multiply(x, y);
    }

    public static Number divide(Number x, Number y) {
        throwIfZero(y);
        return operatorsFor(x, y).divide(x, y);
    }

    public static Unary<Number> divide(final Number divisor) {
        return divide.flip().apply(divisor);
    }

    public static CurriedBinary<Number> divide = Numbers::divide;

    public static CurriedBinary<Number> divide() {
        return divide;
    }

    public static Number quotient(Number x, Number y) {
        throwIfZero(y);
        return reduce(operatorsFor(x, y).quotient(x, y));
    }

    public static Unary<Number> mod(final Number divisor) {
        return mod().apply(divisor);
    }

    public static CurriedBinary<Number> remainder = Numbers::remainder;

    public static CurriedBinary<Number> remainder() {
        return remainder;
    }

    public static CurriedBinary<Number> mod = remainder.flip();

    public static CurriedBinary<Number> mod() {
        return mod;
    }

    public static Unary<Number> remainder(final Number dividend) {
        return remainder().apply(dividend);
    }

    public static Number remainder(Number dividend, Number divisor) {
        throwIfZero(divisor);
        return reduce(operatorsFor(dividend, divisor).remainder(dividend, divisor));
    }

    private static void throwIfZero(Number value) {
        if (operatorsFor(value).isZero(value)) {
            throw DIVIDE_BY_ZERO;
        }
    }

    public static Number number(Number value) {
        return reduce(value);
    }

    public static Number reduce(Number value) {
        if (value instanceof Long)
            return LongOperators.reduce(value.longValue());
        else if (value instanceof BigInteger)
            return BigIntegerOperators.reduce((BigInteger) value);
        return value;
    }

    public static Unary<Number> reduce() {
        return Numbers::reduce;
    }

    public static Function1<Number, Character> toCharacter() {
        return number -> (char) number.shortValue();
    }

    public static String toLexicalString(Number value, final Number minValue, final Number maxValue) {
        String offset = add(value, negate(minValue)).toString();
        int maxSize = add(maxValue, negate(minValue)).toString().length();
        return repeat('0').take(maxSize - offset.length()).join(characters(offset)).toString("");
    }

    public static Number parseLexicalString(String value, final Number minValue) {
        return add(valueOf(value).get(), minValue);
    }

    public static Maximum maximum = new Maximum();

    public static Maximum maximum() {
        return maximum;
    }

    public static Minimum minimum = new Minimum();

    public static Minimum minimum() {
        return minimum;
    }

    public static Lcm lcm = new Lcm();

    public static Lcm lcm() {
        return lcm;
    }

    public static Number lcm(Number x, Number y) {
        return integralOperatorsFor(x, y).lcm(x, y);
    }

    private static IntegralOperators integralOperatorsFor(Number x, Number y) {
        Operators<?> numberOperators = operatorsFor(x, y);
        if (numberOperators instanceof IntegralOperators) return (IntegralOperators) numberOperators;
        throw new UnsupportedOperationException();
    }

    public static Gcd gcd = new Gcd();

    public static Gcd gcd() {
        return gcd;
    }

    public static Number gcd(Number x, Number y) {
        return integralOperatorsFor(x, y).gcd(x, y);
    }
}
