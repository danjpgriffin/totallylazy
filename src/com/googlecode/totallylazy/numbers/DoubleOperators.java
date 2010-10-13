package com.googlecode.totallylazy.numbers;

import static com.googlecode.totallylazy.numbers.Numbers.quotient;
import static com.googlecode.totallylazy.numbers.Numbers.remainder;

/**
 * Copyright (c) Rich Hickey. All rights reserved.
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 */

/* rich Mar 31, 2008 */

public final class DoubleOperators implements Operators<Double> {
    public Class<Double> forClass() {
        return Double.class;
    }

    public final Number negate(Double value) {
        return -value;
    }

    public final Number increment(Double value) {
        return value + 1;
    }

    public final Number decrement(Double value) {
        return value - 1;
    }

    public final boolean isZero(Double value) {
        return value == 0;
    }

    public final boolean isPositive(Double value) {
        return value > 0;
    }

    public final boolean isNegative(Double value) {
        return value < 0;
    }

    public final boolean equalTo(Number x, Number y) {
        return x.doubleValue() == y.doubleValue();
    }

    public final boolean lessThan(Number x, Number y) {
        return x.doubleValue() < y.doubleValue();
    }

    public final Number add(Number x, Number y) {
        return x.doubleValue() + y.doubleValue();
    }

    public final Number multiply(Number x, Number y) {
        return x.doubleValue() * y.doubleValue();
    }

    public final Number divide(Number x, Number y) {
        return x.doubleValue() / y.doubleValue();
    }

    public final Number quotient(Number x, Number y) {
        return Numbers.quotient(x.doubleValue(), y.doubleValue());
    }

    public final Number remainder(Number x, Number y) {
        return Numbers.remainder(x.doubleValue(), y.doubleValue());
    }
}
