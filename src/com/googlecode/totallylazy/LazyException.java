package com.googlecode.totallylazy;

import java.lang.reflect.InvocationTargetException;

public class LazyException extends RuntimeException {
    static final long serialVersionUID = -6664897190745766939L;

    public static LazyException lazyException(final Throwable cause){
        throw new RuntimeException("DAN");
    }


}
