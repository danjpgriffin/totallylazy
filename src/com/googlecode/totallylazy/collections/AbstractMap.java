package com.googlecode.totallylazy.collections;

import com.googlecode.totallylazy.Option;
import com.googlecode.totallylazy.Pair;
import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Segment;
import com.googlecode.totallylazy.Sequence;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("deprecation")
public abstract class AbstractMap<K, V> extends ReadOnlyMap<K,V> implements PersistentMap<K, V> {
    @Override
    public Map<K, V> toMutableMap() {
        throw new RuntimeException("DAN");
    }

    @Override
    public ConcurrentMap<K, V> toConcurrentMap() {
        throw new RuntimeException("DAN");
    }

    @Override
    public Sequence<Pair<K, V>> toSequence() {
        throw new RuntimeException("DAN");
    }

    @Override
    public Sequence<K> keys() {
        throw new RuntimeException("DAN");
    }

    @Override
    public Sequence<V> values() {
        throw new RuntimeException("DAN");
    }

    @Override
    public Option<V> find(Predicate<? super K> predicate) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> filterKeys(Predicate<? super K> predicate) {
        throw new RuntimeException("DAN");
    }

    @Override
    public PersistentMap<K, V> filterValues(Predicate<? super V> predicate) {
        throw new RuntimeException("DAN");
    }

    @Override
    public <C extends Segment<Pair<K, V>>> C joinTo(C rest) {
        throw new RuntimeException("DAN");
    }

    @Override
    public Set<K> keySet() {
        throw new RuntimeException("DAN");
    }

    @Override
    public boolean containsKey(Object key) {
        throw new RuntimeException("DAN");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new RuntimeException("DAN");
    }

    @Override
    public V get(Object key) {
        throw new RuntimeException("DAN");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new RuntimeException("DAN");
    }
}
