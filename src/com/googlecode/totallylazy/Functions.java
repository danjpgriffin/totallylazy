package com.googlecode.totallylazy;

public class Functions {

    public static <A> UnaryFunction<A> identity() {
        return new UnaryFunction<A>() {
            public A call(A self) throws Exception {
                return self;
            }
        };
    }

}
