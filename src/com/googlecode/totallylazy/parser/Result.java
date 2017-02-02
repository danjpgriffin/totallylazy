package com.googlecode.totallylazy.parser;

import com.googlecode.totallylazy.*;
//import com.googlecode.totallylazy.Either;
//import com.googlecode.totallylazy.Segment;


public interface Result<A> extends Value<A>, Functor<A> {
//    Segment<Character> remainder();
//
    @Override
   <B> Result<B> map(Callable1<? super A, ? extends B> callable);
//
//    <B> Result<B> flatMap(Function1<? super A, ? extends Result<B>> callable);
//
    Option<A> option();
//
    Either<String, A> either();
//
//    boolean success();
//
//    boolean failure();
//
//    String message();
//
//    public static class functions {
//        public static <A> Function1<Result<A>, Segment<Character>> remainder() {
//            return new Function1<Result<A>, Segment<Character>>() {
//                @Override
//                public Segment<Character> call(Result<A> result) throws Exception {
//                    return result.remainder();
//                }
//            };
//        }
//    }
}
