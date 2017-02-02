package com.googlecode.totallylazy;

import java.util.concurrent.Callable;

public abstract class Function<A> implements Callable<A>, Runnable, Functor<A>, Value<A> {
    public A apply() {
        throw new RuntimeException("DAN");
    }

    @Override
    public void run() {
        throw new RuntimeException("DAN");
    }

    @Override
    public A value() {
        throw new RuntimeException("DAN");
    }


    @Override
    public <B> Function<B> map(final Callable1<? super A, ? extends B> callable) {
        throw new RuntimeException("DAN");
    }

}