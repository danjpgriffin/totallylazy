package com.googlecode.totallylazy;


import java.util.concurrent.Callable;

public final class Callers {
    public static <T> Function<T> callConcurrently(Callable<? extends T> callable) {
        throw new RuntimeException("DAN");

    }

    public static <T> T call(final Callable<? extends T> callable) {
        throw new RuntimeException("DAN");
        //return Functions.call(callable);
    }

    public static <A, B> B call(final Callable1<? super A, ? extends B> callable, final A a) {
        throw new RuntimeException("DAN");
        //return Functions.call(callable, a);
    }

}