package com.googlecode.totallylazy.collections;

import com.googlecode.totallylazy.Sequence;

public abstract class AbstractCollection<T>
        extends ReadOnlyCollection<T> implements PersistentCollection<T>
{
    @Override
    public Sequence<T> toSequence() {
        throw new RuntimeException("DAN");
    }
//
    @Override
    public T[] toArray(final Class<?> aClass) {
        throw new RuntimeException("DAN");
    }
//
    @Override
    public Object[] toArray() {
        return toSequence().toList().toArray();
    }
//
    @Override
    public <R> R[] toArray(R[] a) {
        return toSequence().toList().toArray(a);
    }

    @Override
    public PersistentCollection<T> deleteAll(Iterable<? extends T> items) {
        throw new RuntimeException("DAN");
    }
}
