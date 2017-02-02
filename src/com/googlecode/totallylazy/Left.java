package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.iterators.EmptyIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

//import static com.googlecode.totallylazy.Callers.call;
//import static com.googlecode.totallylazy.Objects.equalTo;
//import static com.googlecode.totallylazy.Option.none;
//import static com.googlecode.totallylazy.Option.some;

public final class Left<L,R> extends Either<L, R> {
//    private final L value;
//
//    private Left(L value) {
//        this.value = value;
//    }
//
    public static <L,R> Left<L,R> left(L value) {
        throw new RuntimeException("DAN");
        //return new Left<L,R>(value);
    }

    @Override
    public boolean isRight() {
        throw new RuntimeException("DAN");
        //return false;
    }

    @Override
    public boolean isLeft() {
        throw new RuntimeException("DAN");
        //return true;
    }
//
    @Override
    public R right() {
        throw new RuntimeException("DAN");
        //throw new NoSuchElementException();
    }
//
    @Override
    public L left() {
        throw new RuntimeException("DAN");
        //return value;
    }
//
//    @Override
//    public Either<R, L> flip() {
//        throw new RuntimeException("DAN");
//        return right(value);
//    }
//
//    @Override
    public Option<L> leftOption() {
        throw new RuntimeException("DAN");
       // return some(value);
    }
//
    @Override
    public Option<R> rightOption() {
        throw new RuntimeException("DAN");
//        throw new RuntimeException("DAN");
//        return none();
    }
//
//    @Override
//    public <S> S fold(S seed, Callable2<? super S, ? super L, ? extends S> left, Callable2<? super S, ? super R, ? extends S> right) {
//        throw new RuntimeException("DAN");
//        return call(left, seed, left());
//    }

    @Override
    public <S> S map(Callable1<? super L, S> left, Callable1<? super R, ? extends S> right) {
        throw new RuntimeException("DAN");
        //return call(left, left());
    }

    @Override
    public <S> Either<L, S> map(Callable1<? super R, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return left(left());
    }

    @Override
    public <S> Either<S, R> mapLeft(Callable1<? super L, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return left(call(callable, left()));
    }
//
    @Override
    public <S> Either<L, S> flatMap(Callable1<? super R, ? extends Either<L, S>> callable) {
        throw new RuntimeException("DAN");
        //return left(left());
    }

    @Override
    public String toString() {
        throw new RuntimeException("DAN");
       // return "left(" + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        throw new RuntimeException("DAN");
        //return o instanceof Left && equalTo(((Left) o).value, value);
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("DAN");
        //return value == null ? 19 : value.hashCode();
    }

    @Override
    public Object value() {
        throw new RuntimeException("DAN");
        //return value;
    }

    @Override
    public <S> S fold(S seed, Callable2<? super S, ? super R, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return seed;
    }

    @Override
    public Iterator<R> iterator() {
        throw new RuntimeException("DAN");
        //return new EmptyIterator<R>();
    }
}