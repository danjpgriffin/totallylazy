package com.googlecode.totallylazy;

import java.util.Iterator;
import java.util.concurrent.Callable;

public class Some<T> extends Option<T> {
    private final T value;

    private Some(T value) {
        this.value = value;
    }

    public static <T> Some<T> some(T t) {
        if (t == null) {
            throw new IllegalArgumentException("some(T) can not be null");
        }
        return new Some<T>(t);
    }

    public Iterator<T> iterator() {
        throw new RuntimeException("DAN");
        //return sequence(value).iterator();
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Option<T> orElse(Option<T> other) {
        return this;
    }

    @Override
    public Option<T> orElse(Callable<? extends Option<T>> other) {
        return this;
    }

    @Override
    public T getOrElse(T other) {
        throw new RuntimeException("DAN");
        //return get();
    }

    @Override
    public T getOrElse(Callable<? extends T> callable) {
        throw new RuntimeException("DAN");
        //return get();
    }

    @Override
    public T getOrNull() {
        return get();
    }

    @Override
    public <E extends Exception> T getOrThrow(E e) throws E {
        throw new RuntimeException("DAN");
        //return get();
    }

    @Override
    public <S> Option<S> map(Callable1<? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return option(Callers.call(callable, get()));
    }

    @Override
    public Option<T> each(Callable1<? super T, ?> callable) {
        Callers.call(callable, get());
        return this;
    }

    @Override
    public <S> Option<S> flatMap(Callable1<? super T, ? extends Option<? extends S>> callable) {
        throw new RuntimeException("DAN");
        //return cast(Callers.call(callable, get()));
    }

    @Override
    public Option<T> filter(Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
        //return predicate.matches(value) ? this : Option.<T>none();
    }

    @Override
    public <S> S fold(S seed, Callable2<? super S, ? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return Callers.call(callable, seed, get());
    }

    @Override
    public <L> Either<L, T> toEither(L value) {
        throw new RuntimeException("DAN");
        //return right(this.value);
    }

    @Override
    public boolean exists(Predicate<? super T> predicate) {
        return predicate.matches(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Some && ((Some) o).value().equals(value());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "some(" + value + ")";
    }
}