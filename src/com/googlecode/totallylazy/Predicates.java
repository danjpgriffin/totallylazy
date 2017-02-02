package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.predicates.AlwaysFalse;
//import com.googlecode.totallylazy.predicates.AlwaysTrue;
//import com.googlecode.totallylazy.predicates.AndPredicate;
//import com.googlecode.totallylazy.predicates.BetweenPredicate;
//import com.googlecode.totallylazy.predicates.CountTo;
//import com.googlecode.totallylazy.predicates.EqualsPredicate;
//import com.googlecode.totallylazy.predicates.GreaterThanOrEqualToPredicate;
//import com.googlecode.totallylazy.predicates.GreaterThanPredicate;
//import com.googlecode.totallylazy.predicates.InPredicate;
//import com.googlecode.totallylazy.predicates.InstanceOf;
//import com.googlecode.totallylazy.predicates.LessThanOrEqualToPredicate;
//import com.googlecode.totallylazy.predicates.LessThanPredicate;
import com.googlecode.totallylazy.predicates.LogicalPredicate;
//import com.googlecode.totallylazy.predicates.Not;
//import com.googlecode.totallylazy.predicates.NullPredicate;
//import com.googlecode.totallylazy.predicates.OnlyOnce;
//import com.googlecode.totallylazy.predicates.OrPredicate;
//import com.googlecode.totallylazy.predicates.WherePredicate;
//import com.googlecode.totallylazy.predicates.WhileTrue;

import java.util.Collection;

//import static com.googlecode.totallylazy.Functions.function;
//import static com.googlecode.totallylazy.Sequences.sequence;
//import static com.googlecode.totallylazy.Sets.set;
//import static com.googlecode.totallylazy.predicates.LogicalPredicate.logicalPredicate;

public class Predicates {

    public static <T> LogicalPredicate<T> instanceOf(final Class<?> t) {
        throw new RuntimeException("DAN");
        //return new InstanceOf<T>(t);
    }

    public static <T> LogicalPredicate<T> is(final T t) {
        throw new RuntimeException("DAN");
        //return equalTo(t);
    }

    public static <T> LogicalPredicate<T> and(final Predicate<? super T> first, final Predicate<? super T> second) {
        throw new RuntimeException("DAN");
        //return and(Sequences.<Predicate<? super T>>sequence(first, second));
    }
//
    public static <T> LogicalPredicate<T> and(final Predicate<? super T> first, final Predicate<? super T> second, final Predicate<? super T> third) {
        throw new RuntimeException("DAN");
        //return and(Sequences.<Predicate<? super T>>sequence(first, second, third));
    }
//
    public static <T> LogicalPredicate<T> and(final Predicate<? super T> first, final Predicate<? super T> second, final Predicate<? super T> third, final Predicate<? super T> fourth) {
        throw new RuntimeException("DAN");
        //return and(Sequences.<Predicate<? super T>>sequence(first, second, third, fourth));
    }

    public static <T> LogicalPredicate<T> or(final Predicate<? super T> first, final Predicate<? super T> second) {
        throw new RuntimeException("DAN");
        //return or(Sequences.<Predicate<? super T>>sequence(first, second));
    }

    public static <T> LogicalPredicate<T> or(final Predicate<? super T> first, final Predicate<? super T> second, final Predicate<? super T> third) {
        throw new RuntimeException("DAN");
        //return or(Sequences.<Predicate<? super T>>sequence(first, second, third));
    }

    public static <T> LogicalPredicate<T> or(final Iterable<? extends Predicate<? super T>> predicates) {
        throw new RuntimeException("DAN");
        //return OrPredicate.or(predicates);
    }

    public static <T> LogicalPredicate<T> not(final Predicate<? super T> t) {
        throw new RuntimeException("DAN");
        //return Not.not(t);
    }

    public static <T, R> LogicalPredicate<T> where(final Callable1<? super T, ? extends R> callable, final Predicate<? super R> predicate) {
        throw new RuntimeException("DAN");
        //return WherePredicate.where(callable, predicate);
    }

    public static <F> LogicalPredicate<First<F>> first(Predicate<? super F> predicate) {
        throw new RuntimeException("DAN");
        //return where(Callables.<F>first(), predicate);
    }
//
    public static <S> LogicalPredicate<Second<S>> second(Predicate<? super S> predicate) {
        throw new RuntimeException("DAN");
        //return where(Callables.<S>second(), predicate);
    }
}
