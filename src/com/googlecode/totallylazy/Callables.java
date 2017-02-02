package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.comparators.Comparators;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Callable;

//import static com.googlecode.totallylazy.Methods.method;
//import static com.googlecode.totallylazy.Option.identity;
//import static com.googlecode.totallylazy.Sequences.sequence;

public final class Callables {
    public static <T> Function1<Value<T>, T> value() {
        throw new RuntimeException("DAN");
    }

    public static <T> Function1<Value<T>, T> value(Class<T> aClass) {
        return value();
    }

    public static <T, R extends Comparable<? super R>> Comparator<T> descending(final Callable1<? super T, ? extends R> callable) {
        throw new RuntimeException("DAN");
        //return Comparators.descending(callable);
    }

    public static <T> Function1<First<T>, T> first(Class<T> aClass) {
        return first();
    }

    public static <T> Function1<First<T>, T> first() {
        throw new RuntimeException("DAN");
    }

    public static <F, S, R> Function1<Pair<F, S>, Pair<R, S>> first(final Callable1<? super F, ? extends R> firstCallable, Class<S> sClass) {
        throw new RuntimeException("DAN");
        //return first(firstCallable);
    }

    public static <T> Function1<Second<T>, T> second(Class<T> aClass) {
        throw new RuntimeException("DAN");
        //return second();
    }

    public static <T> UnaryFunction<T> when(final Predicate<? super T> predicate, final Callable1<? super T, ? extends T> callable) {
        throw new RuntimeException("DAN");

    }
}