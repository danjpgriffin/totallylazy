package com.googlecode.totallylazy;

import java.util.Map;


public class Pair<F, S>
        implements First<F>, Second<S>, Value<F>, Functor<F>,
        Map.Entry<F,S>
{

    public static <F, S> Pair<F, S> pair(final F first, final S second) {
        throw new RuntimeException("DAN");
        //return new Pair<F, S>(returns(first), returns(second));
    }

    public final F first() {
        throw new RuntimeException("DAN");
        //return first.value();
    }

    public final S second() {
        throw new RuntimeException("DAN");
        //return second.value();
    }
//
    @Override
    public F value() {
        return first();
    }

    public Sequence<Object> values() {
        throw new RuntimeException("DAN");
        //return sequence(first(), second());
    }
//
    @Override
    public F getKey() {
        throw new RuntimeException("DAN");
        //return first();
    }

    @Override
    public S getValue() {
        throw new RuntimeException("DAN");
        //return second();
    }

    @Override
    public S setValue(S value) {
        throw new UnsupportedOperationException();
    }

    public <NewF> Pair<NewF, S> map(final Callable1<? super F, ? extends NewF> callable) {
        throw new RuntimeException("DAN");
        //return pair(first.map(callable), second);
    }
}
