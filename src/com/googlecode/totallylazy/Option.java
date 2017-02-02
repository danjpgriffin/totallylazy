package com.googlecode.totallylazy;

import java.util.concurrent.Callable;

import static com.googlecode.totallylazy.Sequences.sequence;

public abstract class Option<A> implements Iterable<A>, Value<A>, Functor<A>,
        Foldable<A> {
    public static <A> Option<A> option(A a) {
        if (a == null) {
            return None.none();
        }
        return Some.some(a);
    }

    public static <A> Option<A> option(Callable<? extends A> t) {
        try {
            return Option.option(t.call());
        } catch (Exception e) {
            return none();
        }
    }
//
    public static <A> Option<A> some(A a) {
        return Some.some(a);
    }
//
    public static <A> Option<A> none() {
        return None.none();
    }
//
    public static <A> Option<A> none(Class<A> aClass) {
        return None.none(aClass);
    }

    public static <T> UnaryFunction<Option<T>> identity() {
        throw new RuntimeException("DAN");
        //return Functions.identity();
    }
//
    public A value() {
        throw new RuntimeException("DAN");
        //return get();
    }
//
    public abstract A get();
//
    public abstract boolean isEmpty();
//
    public boolean isDefined() { return !isEmpty(); }
//
    public abstract Option<A> orElse(Option<A> other);
//
    public abstract Option<A> orElse(Callable<? extends Option<A>> other);
//
    public abstract A getOrElse(A other);
//
    public abstract A getOrElse(Callable<? extends A> callable);
//
    public abstract A getOrNull();
//
    public abstract <E extends Exception> A getOrThrow(E e) throws E;
//
    public abstract <B> Option<B> map(Callable1<? super A, ? extends B> callable);
//
    public abstract Option<A> each(Callable1<? super A, ?> callable);
//
    public abstract <B> Option<B> flatMap(Callable1<? super A, ? extends Option<? extends B>> callable);
//
    public abstract Option<A> filter(Predicate<? super A> predicate);

    public Sequence<A> toSequence() {
        return sequence(this);
    }
//
    public abstract <L> Either<L, A> toEither(L value);

    public <T> Option<T> unsafeCast() {
        return Unchecked.cast(this);
    }
//
    public <T> Option<T> unsafeCast(Class<T> aClass) {
        return unsafeCast();
    }

    public abstract boolean exists(Predicate<? super A> predicate);
//
    public boolean is(Predicate<? super A> predicate) { return exists(predicate);}

}