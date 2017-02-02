package com.googlecode.totallylazy;

import java.util.concurrent.Callable;

public class Triple<F, S, T> extends Pair<F, S> implements Third<T> {
    private final Value<? extends T> third;

    public static <F, S, T> Triple<F, S, T> triple(final F first, final S second, final T third) {
        throw new RuntimeException("DAN");
        //return new Triple<F, S, T>(returns(first), returns(second), returns(third));
    }

    protected Triple(final Callable<? extends F> first, final Callable<? extends S> second, final Callable<? extends T> third) {
        throw new RuntimeException("DAN");
    }

    public final T third() {
        return third.value();
    }

    @Override
    public Sequence<Object> values() {
        return super.values().append(third());
    }

}
