package com.googlecode.totallylazy.collections;

import com.googlecode.totallylazy.Callable1;
import com.googlecode.totallylazy.Callables;
import com.googlecode.totallylazy.Filterable;
import com.googlecode.totallylazy.Foldable;
import com.googlecode.totallylazy.Functor;
//import com.googlecode.totallylazy.Mapper;
import com.googlecode.totallylazy.Maps;
import com.googlecode.totallylazy.Option;
import com.googlecode.totallylazy.Pair;
import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Segment;
import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Unchecked;
//import com.googlecode.totallylazy.comparators.Comparators;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

import static com.googlecode.totallylazy.Pair.pair;
import static com.googlecode.totallylazy.Sequences.sequence;

public interface PersistentMap<K, V> extends Map<K, V>, Iterable<Pair<K, V>>, Segment<Pair<K, V>>, PersistentContainer<K>, Functor<V>, Foldable<Pair<K, V>>, Filterable<Pair<K, V>> {
    Option<V> lookup(K key);

    Option<V> find(Predicate<? super K> predicate);

    PersistentMap<K, V> insert(K key, V value);

    PersistentMap<K, V> delete(K key);

    @Override
    PersistentMap<K, V> filter(Predicate<? super Pair<K, V>> predicate);

    PersistentMap<K, V> filterKeys(Predicate<? super K> predicate);

    PersistentMap<K, V> filterValues(Predicate<? super V> predicate);

    @Override
    PersistentMap<K, V> empty();

    @Override
    PersistentMap<K, V> cons(Pair<K, V> head);

    @Override
    PersistentMap<K, V> tail() throws NoSuchElementException;

    @Override
    <NewV> PersistentMap<K, NewV> map(Callable1<? super V, ? extends NewV> transformer);

    //PersistentList<Pair<K, V>> toPersistentList();

    Sequence<Pair<K, V>> toSequence();

    Sequence<K> keys();

    @Override
    Sequence<V> values();

    Map<K, V> toMutableMap();

    ConcurrentMap<K, V> toConcurrentMap();

    /**
     * @deprecated Not type safe: Replaced by {@link PersistentMap#delete(K)}
     */
    @Override
    @Deprecated
    V remove(Object o);

    /**
     * @deprecated Not type safe: Replaced by {@link PersistentMap#insert(K, V)}
     */
    @Override
    @Deprecated
    V put(K key, V value);

    /**
     * @deprecated Not type safe: Replaced by {@link PersistentMap#insert(K, V)}
     */
    @Override
    @Deprecated
    void putAll(Map<? extends K, ? extends V> m);

    /**
     * @deprecated Not type safe: Replaced by {@link PersistentMap#empty()}
     */
    @Override
    @Deprecated
    void clear();

    class constructors {
        public static <K, V> PersistentMap<K, V> map() {
            throw new RuntimeException("DAN");
            //return HashTreeMap.hashTreeMap();
        }
//
        public static <K, V> PersistentMap<K, V> emptyMap() {
            return map();
        }

        public static <K, V> PersistentMap<K, V> map(K key, V value) {
            return map(sequence(pair(key, value)));
        }
//
        public static <K, V> PersistentMap<K, V> map(K key1, V value1, K key2, V value2) {
            return map(sequence(pair(key1, value1), pair(key2, value2)));
        }
//
        public static <K, V> PersistentMap<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
            return map(sequence(pair(key1, value1), pair(key2, value2), pair(key3, value3)));
        }
//
        public static <K, V> PersistentMap<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
            return map(sequence(pair(key1, value1), pair(key2, value2), pair(key3, value3), pair(key4, value4)));
        }
//
        public static <K, V> PersistentMap<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5, V value5) {
            return map(sequence(pair(key1, value1), pair(key2, value2), pair(key3, value3), pair(key4, value4), pair(key5, value5)));
        }
//
        public static <K, V> PersistentMap<K, V> map(final Pair<K, V> head, final Pair<K, V>... tail) {
            throw new RuntimeException("DAN");
            //return map(sequence(tail).cons(head));
        }
//
        public static <K, V> PersistentMap<K, V> map(final Iterable<? extends Pair<K, V>> values) {
            throw new RuntimeException("DAN");
            //return HashTreeMap.hashTreeMap(values);
        }
//
        public static <K, V> PersistentMap<K, V> map(final Map<K, V> values) {
            throw new RuntimeException("DAN");
            //return map(Maps.pairs(values));
        }
    }

}
