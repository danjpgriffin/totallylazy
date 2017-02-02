package com.googlecode.totallylazy.parser;

import com.googlecode.totallylazy.*;


public interface Result<A> extends Value<A>, Functor<A> {
    @Override
   <B> Result<B> map(Callable1<? super A, ? extends B> callable);
    Option<A> option();
    Either<String, A> either();

}
