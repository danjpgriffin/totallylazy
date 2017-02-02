package com.googlecode.totallylazy;


import java.util.LinkedHashMap;
import java.util.Map;


public class Maps {
    public static <K, V> Sequence<Pair<K, V>> pairs(final Map<K, V> map) {
        throw new RuntimeException("DAN");
        //return entries(map).map(Maps.<K, V>entryToPair());
    }

    public static <K, V> Sequence<Map.Entry<K, V>> entries(final Map<K, V> map) {
        throw new RuntimeException("DAN");
        //return sequence(map.entrySet());
    }
//
    public static <K, V> Map<K, V> map() {
        return new LinkedHashMap<K, V>();
    }
//
    public static <K, V> Map<K, V> map(K key, V value) {
        throw new RuntimeException("DAN");
        //return map(pair(key, value));
    }

    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2) {
        throw new RuntimeException("DAN");
        //return map(pair(key1, value1), pair(key2, value2));
    }
//
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
        throw new RuntimeException("DAN");
        //return map(pair(key1, value1), pair(key2, value2), pair(key3, value3));
    }
//
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        throw new RuntimeException("DAN");
        //return map(pair(key1, value1), pair(key2, value2), pair(key3, value3), pair(key4, value4));
    }
//
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5, V value5) {
        throw new RuntimeException("DAN");
        //return map(pair(key1, value1), pair(key2, value2), pair(key3, value3), pair(key4, value4), pair(key5, value5));
    }
//
    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V> first) {
        throw new RuntimeException("DAN");
        //return map(sequence(first));
    }

    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V> first, final Pair<? extends K, ? extends V> second) {
        throw new RuntimeException("DAN");
        //return map(sequence(first, second));
    }
//
    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V> first, final Pair<? extends K, ? extends V> second, final Pair<? extends K, ? extends V> third) {
        throw new RuntimeException("DAN");
        //return map(sequence(first, second, third));
    }
//
    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V> first, final Pair<? extends K, ? extends V> second, final Pair<? extends K, ? extends V> third, final Pair<? extends K, ? extends V> fourth) {
        throw new RuntimeException("DAN");
        //return map(sequence(first, second, third, fourth));
    }
//
    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V> first, final Pair<? extends K, ? extends V> second, final Pair<? extends K, ? extends V> third, final Pair<? extends K, ? extends V> fourth, final Pair<? extends K, ? extends V> fifth) {
        throw new RuntimeException("DAN");
        //return map(sequence(first, second, third, fourth, fifth));
    }
//
    public static <K, V> Map<K, V> map(final Pair<? extends K, ? extends V>... entries) {
        throw new RuntimeException("DAN");
        //return map(sequence(entries));
    }
//
    public static <K, V> Map<K, V> map(final Map<K, V> seed, final Pair<? extends K, ? extends V>... entries) {
        throw new RuntimeException("DAN");
        //return map(seed, sequence(entries));
    }
//
    public static <K, V> Map<K, V> map(final Iterable<? extends Pair<? extends K, ? extends V>> entries) {
        //return map(new LinkedHashMap<K, V>(), entries);
        throw new RuntimeException("DAN");
    }
//
    public static <K, V> Map<K, V> map(final Map<K, V> seed, final Iterable<? extends Pair<? extends K, ? extends V>> entries) {
        for (Pair<? extends K, ? extends V> entry : entries) {
            seed.put(entry.first(), entry.second());
        }
        return seed;
    }

    public static <K, V> Option<V> get(Map<K, V> map, K key) {
        return Option.option(map.get(key));
    }

    public static <K, V, NewK> Map<NewK, V> mapKeys(Map<K, V> map, Callable1<? super K, ? extends NewK> transformer) {
        throw new RuntimeException("DAN");
    }

}