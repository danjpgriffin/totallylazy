package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.predicates.LogicalPredicate;

import java.util.List;

import static com.googlecode.totallylazy.Sequences.sequence;

public class Arrays {

    public static <T> List<T> list(T... values) {
        throw new RuntimeException("DAN");
        //return Lists.list(values);
    }

    public static <T> T[] tail(T[] array) {
        return java.util.Arrays.copyOfRange(array, 1, array.length);
    }

}
