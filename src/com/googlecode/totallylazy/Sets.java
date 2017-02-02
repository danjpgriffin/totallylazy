package com.googlecode.totallylazy;

import java.util.Set;

public class Sets {

    public static <T> Set<T> set(T... values) {
        throw new RuntimeException("DAN");
    }

    public static <T> Set<T> set(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
    }

    public static <T> Set<T> union(final Set<? extends T> first, final Set<? extends T> second) {
        throw new RuntimeException("DAN");
    }
}
