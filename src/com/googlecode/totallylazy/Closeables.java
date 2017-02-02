package com.googlecode.totallylazy;

import java.io.Closeable;

public class Closeables {

    public static <T extends Closeable, R> R using(T t, Callable1<? super T, ? extends R> callable) {
     throw new RuntimeException("DAN");

    }

    public static <A extends Closeable, B extends Closeable, R> R using(A a, B b, Callable2<? super A, ? super B, ? extends R> callable) {
        throw new RuntimeException("DAN");

    }
//
    public static <T, R> R using(T instanceWithCloseMethod, Callable1<? super T, ? extends R> callable) {
        throw new RuntimeException("DAN");
//
    }

}