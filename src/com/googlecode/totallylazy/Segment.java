package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.iterators.SegmentIterator;
//import com.googlecode.totallylazy.segments.AbstractSegment;
//import com.googlecode.totallylazy.segments.CharacterSegment;

import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

public interface Segment<T> {
    boolean isEmpty();

    T head() throws NoSuchElementException;

    Option<T> headOption();

    Segment<T> empty();

    Segment<T> cons(T head);

    Segment<T> tail() throws NoSuchElementException;

    <C extends Segment<T>> C joinTo(C rest);

}
