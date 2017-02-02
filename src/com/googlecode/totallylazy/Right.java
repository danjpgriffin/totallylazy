package com.googlecode.totallylazy;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Right<L,R> extends Either<L,R> {
    private final R value;

    private Right(R value) {
        this.value = value;
    }

    public static <L,R> Right<L,R> right(R value) {
        return new Right<L,R>(value);
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public R right() {
        return value;
    }

    @Override
    public L left() {
        throw new NoSuchElementException();
    }

    @Override
    public Option<L> leftOption() {
        throw new RuntimeException("DAN");
        //return none();
    }

    @Override
    public Option<R> rightOption() {
        throw new RuntimeException("DAN");
        //return some(value);
    }

    @Override
    public <S> S map(Callable1<? super L, S> left, Callable1<? super R, ? extends S> right) {
        throw new RuntimeException("DAN");
        //return call(right, right());
    }

    @Override
    public <S> Either<L, S> map(Callable1<? super R, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return right(call(callable, right()));
    }

    @Override
    public <S> Either<S, R> mapLeft(Callable1<? super L, ? extends S> callable) {
        return right(right());
    }
//
    @Override
    public <S> Either<L, S> flatMap(Callable1<? super R, ? extends Either<L, S>> callable) {
        throw new RuntimeException("DAN");
        //return call(callable, right());
    }

    @Override
    public String toString() {
        return "right(" + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        throw new RuntimeException("DAN");
        //return o instanceof Right && equalTo(((Right) o).value, value);
    }

    @Override
    public int hashCode() {
        return value == null ? 31 : value.hashCode();
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public <S> S fold(S seed, Callable2<? super S, ? super R, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return call(callable, seed, value);
    }

    @Override
    public Iterator<R> iterator() {
        throw new RuntimeException("DAN");
        //return one(value).iterator();
    }
}
