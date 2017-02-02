package com.googlecode.totallylazy;

public abstract class Block<T> extends Function1<T, Void> {
    @Override
    public Void call(T t) throws Exception {
        throw new RuntimeException("DAN");
    }

    protected abstract void execute(T t) throws Exception;
}
