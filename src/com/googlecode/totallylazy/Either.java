package com.googlecode.totallylazy;

import java.util.concurrent.Callable;

public abstract class Either<L, R> implements Iterable<R>, Value<Object>, Functor<R>,
        Foldable<R> {
    public static <L, R> Either<L, R> right(R value) {
        return Right.right(value);
    }
//
    public static <L, R> Either<L, R> right(Class<L> leftType, R value) {
        return Right.right(value);
    }
//
    public static <L, R> Either<L, R> left(L value) {
        return Left.left(value);
    }

    public static <R> Either<Exception, R> either(Callable<? extends R> callable) {
        try {
            return Either.right(callable.call());
        } catch (Exception e) {
            return Either.left(e);
        }
    }
//
    public abstract boolean isRight();
//
    public abstract boolean isLeft();
//
    public abstract R right();
//
    public abstract L left();
//
    public abstract <S> S map(final Callable1<? super L, S> left, final Callable1<? super R, ? extends S> right);
//
//    @Override
    public abstract <S> Either<L, S> map(Callable1<? super R, ? extends S> callable);
//
    public abstract <S> Either<S, R> mapLeft(Callable1<? super L, ? extends S> callable);
//
    public abstract <S> Either<L, S> flatMap(Callable1<? super R, ? extends Either<L, S>> callable);

    public static <L, R> Function1<Either<L, R>, Either<L, R>> identity(Class<L> lClass, Class<R> rClass) {
        return identity();
    }
//
    public static <L, R> Function1<Either<L, R>, Either<L, R>> identity() {
        throw new RuntimeException("DAN");
        }

    public abstract Option<L> leftOption();
//
    public abstract Option<R> rightOption();

}
