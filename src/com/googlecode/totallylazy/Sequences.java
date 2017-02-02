package com.googlecode.totallylazy;

import java.util.List;


public class Sequences {
    public static <T> Sequence<T> empty(Class<T> aClass) {
        return empty();
    }
//
    public static <T> Sequence<T> empty() {
        throw new RuntimeException("DAN");

    }
//
    public static <T> Sequence<T> sequence(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");

    }
//
    @SuppressWarnings("unchecked")
    public static <T> Sequence<T> one(final T first) {
        throw new RuntimeException("DAN");
        //return internal(first);
    }
//
    @SuppressWarnings("unchecked")
    public static <T> Sequence<T> sequence(final T first) {
        throw new RuntimeException("DAN");
        //return internal(first);
    }

    public static <T> Sequence<T> sequence(final T... items) {
        throw new RuntimeException("DAN");

    }

    public static <T, S> Sequence<S> map(final Iterable<? extends T> iterable, final Callable1<? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");

    }

    public static <T, S> Sequence<S> flatMap(final Iterable<? extends T> iterable, final Callable1<? super T, ? extends Iterable<? extends S>> callable) {
        throw new RuntimeException("DAN");

    }

    public static <T> Option<T> headOption(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
        //return Iterators.headOption(iterable.iterator());
    }

    public static <T> List<T> toList(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
        //return Iterators.toList(iterable.iterator());
    }

    public static <T> Sequence<T> join(final Iterable<? extends T>... iterables) {
        throw new RuntimeException("DAN");
        //return join(sequence(iterables));
    }

    public static <F, S> Sequence<Pair<F, S>> zip(final Iterable<? extends F> first, final Iterable<? extends S> second) {
        throw new RuntimeException("DAN");

    }

    public static <T> Sequence<T> realise(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
        //return sequence(Iterators.toList(iterable.iterator()));
    }


}