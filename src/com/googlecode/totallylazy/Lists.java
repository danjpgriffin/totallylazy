package com.googlecode.totallylazy;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.totallylazy.Sequences.sequence;

public class Lists {
    public static <T> List<T> list(T... values) {
        throw new RuntimeException("DAN");
        //return list(sequence(values));
    }

    public static <T> List<T> list(Iterable<T> iterable) {
        return sequence(iterable).toList();
    }

}
