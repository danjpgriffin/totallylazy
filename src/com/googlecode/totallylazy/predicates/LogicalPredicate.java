package com.googlecode.totallylazy.predicates;

import com.googlecode.totallylazy.Function1;
import com.googlecode.totallylazy.Predicate;

public abstract class LogicalPredicate<T> extends Function1<T, Boolean> implements Predicate<T> {
    @Override
    public Boolean call(T t) throws Exception {
        throw new RuntimeException("DAN");
    }
}
