package com.googlecode.totallylazy.collections;

import com.googlecode.totallylazy.Filterable;
import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Segment;
import com.googlecode.totallylazy.Sequence;

import java.util.Collection;
import java.util.NoSuchElementException;

public interface PersistentCollection<T> extends PersistentContainer<T>, Collection<T>, Segment<T>, Filterable<T> {
    @Override
    PersistentCollection<T> empty();

    @Override
    PersistentCollection<T> cons(T t);

    @Override
    PersistentCollection<T> tail() throws NoSuchElementException;

    PersistentCollection<T> delete(T t);

    PersistentCollection<T> deleteAll(Iterable<? extends T> items);

    @Override
    PersistentCollection<T> filter(Predicate<? super T> predicate);

    Sequence<T> toSequence();

    T[] toArray(Class<?> aClass);
}
