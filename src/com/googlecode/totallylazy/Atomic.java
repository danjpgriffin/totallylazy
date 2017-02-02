package com.googlecode.totallylazy;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

//import static com.googlecode.totallylazy.Callables.returns;
//import static com.googlecode.totallylazy.Callers.call;
//import static com.googlecode.totallylazy.Functions.function;
//import static com.googlecode.totallylazy.Predicates.always;

public interface Atomic<T> extends Value<T> {
    Atomic<T> modify(Callable1<? super T, ? extends T> callable);

    class constructors {
        public static <T> Atomic<T> atomic(final T t) {
            throw new RuntimeException("DAN");
            //return atomic(t, returns(always(Integer.class)));
        }
    }


}