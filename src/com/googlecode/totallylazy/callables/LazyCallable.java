package com.googlecode.totallylazy.callables;

import com.googlecode.totallylazy.Function;
import com.googlecode.totallylazy.Memory;

import java.util.concurrent.Callable;

public class LazyCallable<T> extends Function<T> implements Memory {
    private final Callable<? extends T> callable;
    private final Object lock = new Object();
    private volatile T state;

    private LazyCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public static <T> LazyCallable<T> lazy(Callable<? extends T> callable) {
        return new LazyCallable<T>(callable);
    }

    // Thread-safe double check idiom (Effective Java 2nd edition p.283)
    public final T call() throws Exception {
        if (state == null) {
            synchronized (lock) {
                if (state == null) {
                    state = callable.call();
                }
            }
        }
        return state;
    }

    public void forget() {
        synchronized (lock) {
            state = null;
        }
    }
}
