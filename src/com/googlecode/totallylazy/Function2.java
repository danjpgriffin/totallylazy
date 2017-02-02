package com.googlecode.totallylazy;


public abstract class Function2<A, B, C> extends Function1<A, Function1<B, C>> implements Callable2<A, B, C> {
    @Override
    public Function1<B, C> call(final A a) throws Exception {
        throw new RuntimeException("DAN");
        //return Functions.apply(this, a);
    }

}
