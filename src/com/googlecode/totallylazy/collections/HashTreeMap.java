package com.googlecode.totallylazy.collections;

import com.googlecode.totallylazy.Callable1;
import com.googlecode.totallylazy.Callable2;
import com.googlecode.totallylazy.Callables;
import com.googlecode.totallylazy.Option;
import com.googlecode.totallylazy.Pair;
import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Predicates;
import com.googlecode.totallylazy.Sequences;
//import com.googlecode.totallylazy.annotations.multimethod;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.googlecode.totallylazy.Sequences.sequence;

public class HashTreeMap<K, V> extends AbstractMap<K, V> {

    public static <K, V> HashTreeMap<K, V> hashTreeMap() {
        throw new RuntimeException("DAN");
    }
//
    public static <K, V> HashTreeMap<K, V> hashTreeMap(Iterable<? extends Pair<K, V>> values) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> empty() {
        throw new RuntimeException("DAN");
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException("DAN");
    }

    @Override
    public Pair<K, V> head() throws NoSuchElementException {
        return iterator().next();
    }

    @Override
    public Option<Pair<K, V>> headOption() {
        if(isEmpty()) return Option.none();
        return Option.some(head());
    }

    @Override
    public PersistentMap<K, V> cons(Pair<K, V> head) {
        return insert(head.first(), head.second());
    }

    @Override
    public PersistentMap<K, V> tail() throws NoSuchElementException {
        return delete(head().first());
    }

    @Override
    public Option<V> lookup(final K key) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> insert(K key, V value) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> delete(K key) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> filter(Predicate<? super Pair<K, V>> predicate) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> filterKeys(Predicate<? super K> predicate) {
        return filter(Predicates.<K>first(predicate));
    }

    @Override
    public PersistentMap<K, V> filterValues(Predicate<? super V> predicate) {
        return filter(Predicates.<V>second(predicate));
    }

    @Override
    public <NewV> PersistentMap<K, NewV> map(Callable1<? super V, ? extends NewV> transformer) {
        throw new RuntimeException("DAN");
    }

    @Override
    public <S> S fold(S seed, Callable2<? super S, ? super Pair<K, V>, ? extends S> callable) {
        return toSequence().fold(seed, callable);
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        throw new RuntimeException("DAN");
    }

    @Override
    public boolean contains(final Object other) {
        throw new RuntimeException("DAN");
    }

    @Override
    public boolean exists(Predicate<? super K> predicate) {
        return toSequence().exists(Predicates.<K>first(predicate));
    }

    @Override
    public int size() {
        return toSequence().size();
    }

    @Override
    public int hashCode() {
        return toSequence().hashCode();
    }

    //@multimethod
    public boolean equals(HashTreeMap<K, V> obj) {
        return toSequence().equals(obj.toSequence());
    }

    @Override
    public String toString() {
        return toSequence().toString("");
    }
}
