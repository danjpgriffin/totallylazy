package com.googlecode.totallylazy;

import com.googlecode.totallylazy.collections.AbstractCollection;
import com.googlecode.totallylazy.collections.Indexed;
import com.googlecode.totallylazy.collections.PersistentCollection;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class Sequence<T>
        extends AbstractCollection<T>
        implements Iterable<T>, First<T>, Second<T>,
        Third<T>,
        Functor<T>, Segment<T>,
        PersistentCollection<T>,
        Foldable<T>,
        Indexed<T>
        , Filterable<T>
{

    public void eachConcurrently(final Callable1<? super T, ?> runnable) {
        throw new RuntimeException("DAN");
    }

    public void each(final Callable1<? super T, ?> runnable) {
        throw new RuntimeException("DAN");
        //forEach(runnable);
    }
//
    public void forEach(final Callable1<? super T, ?> runnable) {
        throw new RuntimeException("DAN");
    }

    public <S> Sequence<S> mapConcurrently(final Callable1<? super T, S> callable) {
        throw new RuntimeException("DAN");
    }

    public <S> Sequence<S> mapConcurrently(final Callable1<? super T, S> callable, final Executor executor) {
        throw new RuntimeException("DAN");
    }

    public <S> Sequence<S> map(final Callable1<? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
    }

    @Override
    public Sequence<T> filter(final Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
        //return Sequences.filter(this, predicate);
    }
//
    public Sequence<T> reject(final Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
    }

    public <S> Sequence<S> flatMap(final Callable1<? super T, ? extends Iterable<? extends S>> callable) {
        return Sequences.flatMap(this, callable);
    }

    public T first() {
        throw new RuntimeException("DAN");
    }
//
    public T last() {
        throw new RuntimeException("DAN");
    }

    public Option<T> lastOption() {
        throw new RuntimeException("DAN");
    }
//
    public T second() {
        throw new RuntimeException("DAN");
    }
//
    @Override
    public T third() {
        throw new RuntimeException("DAN");
    }
//
    public T head() {
        throw new RuntimeException("DAN");
    }
//
    public Option<T> headOption() {
        throw new RuntimeException("DAN");
    }
//
    public Sequence<T> tail() {
        throw new RuntimeException("DAN");
    }

    public <S> S fold(final S seed, final Callable2<? super S, ? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
    }
//
    public <S> S foldLeft(final S seed, final Callable2<? super S, ? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
    }
//
    public <S> S foldRight(final S seed, final Callable2<? super T, ? super S, ? extends S> callable) {
        throw new RuntimeException("DAN");
    }

    public <S> S reduce(final Callable2<? super S, ? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
    }

    public String toString(final String separator) {
        throw new RuntimeException("DAN");
        //return Sequences.toString(this, separator);
    }

    public Set<T> union(final Iterable<? extends T> other) {
        throw new RuntimeException("DAN");
        //return Sets.union(toSet(), Sets.set(other));
    }
//
    public Set<T> intersection(final Iterable<? extends T> other) {
        throw new RuntimeException("DAN");
        //return Sets.intersection(sequence(toSet(), Sets.set(other)));
    }

    public Set<T> toSet() {
        throw new RuntimeException("DAN");
        //return toSet(new LinkedHashSet<T>());
    }
//
    public Sequence<T> unique() {
        throw new RuntimeException("DAN");
        //return unique(returnArgument());
    }
//
    public <S> Sequence<T> unique(Callable1<? super T, ? extends S> callable) {
        throw new RuntimeException("DAN");
        //return Sequences.unique(this, callable);
    }
//
    @Override
    public Sequence<T> empty() {
        return Sequences.empty();
    }
//
    public boolean isEmpty() {
        throw new RuntimeException("DAN");
        //return Sequences.isEmpty(this);
    }
//
    public List<T> toList() {
        throw new RuntimeException("DAN");
        //return Sequences.toList(this);
    }

    @Override
    public Sequence<T> delete(final T t) {
        throw new RuntimeException("DAN");
        //return Sequences.delete(this, t);
    }
//
    @Override
    public Sequence<T> deleteAll(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
        //return Sequences.deleteAll(this, iterable);
    }
//
    public int size() {
        throw new RuntimeException("DAN");
        //return Sequences.size(this);
    }

    public Sequence<T> take(final int count) {
        throw new RuntimeException("DAN");
        //return Sequences.take(this, count);
    }

    public Sequence<T> drop(final int count) {
        throw new RuntimeException("DAN");
        //return Sequences.drop(this, count);
    }

    public boolean forAll(final Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
        //return Sequences.forAll(this, predicate);
    }
//
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("DAN");
        //return forAll(in(c));
    }
//
    @Override
    public boolean contains(Object o) {
        throw new RuntimeException("DAN");
        //return exists(is(o));
    }
//
    public boolean exists(final Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
        //return Sequences.exists(this, predicate);
    }
//
    public Option<T> find(final Predicate<? super T> predicate) {
        throw new RuntimeException("DAN");
        //return Sequences.find(this, predicate);
    }

    public Sequence<T> append(final T t) {
        throw new RuntimeException("DAN");
        //return Sequences.append(this, t);
    }
//
    public Sequence<T> join(final Iterable<? extends T> iterable) {
        throw new RuntimeException("DAN");
        //return Sequences.join(this, iterable);
    }
//
    @Override
    public <C extends Segment<T>> C joinTo(C rest) {
        throw new RuntimeException("DAN");
        //return Sequences.joinTo(this, rest);
    }
//
    public Sequence<T> cons(final T t) {
        throw new RuntimeException("DAN");
        //return Sequences.cons(t, this);
    }

    public <S> Sequence<Pair<T, S>> zip(final Iterable<? extends S> second) {
        return Sequences.zip(this, second);
    }

    public Sequence<Pair<Number, T>> zipWithIndex() {
        throw new RuntimeException("DAN");
        //return Sequences.zipWithIndex(this);
    }
//
    public <R extends Comparable<? super R>> Sequence<T> sortBy(final Callable1<? super T, ? extends R> callable) {
        throw new RuntimeException("DAN");
        //return sortBy(ascending(callable));
    }
//
    public Sequence<T> sort(final Comparator<? super T> comparator) {
        throw new RuntimeException("DAN");
        //return sortBy(comparator);
    }
//
    public Sequence<T> sortBy(final Comparator<? super T> comparator) {
        throw new RuntimeException("DAN");
        // return Sequences.sortBy(this, comparator);
    }
//
    public <S> Sequence<S> safeCast(final Class<? extends S> aClass) {
        throw new RuntimeException("DAN");
        //return Sequences.safeCast(this, aClass);
    }
//
    public <S> Sequence<S> unsafeCast() {
        throw new RuntimeException("DAN");
        //return Sequences.unsafeCast(this);
    }
//
    public Sequence<T> realise() {
        return Sequences.realise(this);
    }

    public Sequence<T> reverse() {
        throw new RuntimeException("DAN");
        //return Sequences.reverse(this);
    }

    public <K> Map<K, List<T>> toMap(final Callable1<? super T, ? extends K> callable) {
        throw new RuntimeException("DAN");
        //return Maps.multiMap(this, callable);
    }
//
    public <K> Sequence<Group<K, T>> groupBy(final Callable1<? super T, ? extends K> callable) {
        throw new RuntimeException("DAN");
        //return Sequences.groupBy(this, callable);
    }

    public Pair<Sequence<T>, Sequence<T>> splitAt(final Number index) {
        throw new RuntimeException("DAN");
        //return Sequences.splitAt(this, index);
    }

    public T get(int index) {
        throw new RuntimeException("DAN");
        //return drop(index).head();
    }

    public Option<Sequence<T>> flatOption() {
        throw new RuntimeException("DAN");
        //return Sequences.flatOption(this);
    }
//
    @Override
    public int indexOf(Object t) {
        throw new RuntimeException("DAN");
        //return Sequences.indexOf(this, t);
    }

}