package com.googlecode.totallylazy;

public abstract class Function1<A, B>
        extends Eq
        implements Callable1<A, B>, Functor<B> {
    public B apply(final A a) {
        throw new RuntimeException("DAN");
        //return Functions.call(this, a);
    }

    @Override
    public <C> Function1<A, C> map(final Callable1<? super B, ? extends C> callable) {
        throw new RuntimeException("DAN");
        //return Callables.compose(this, callable);
    }

}
