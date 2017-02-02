package com.googlecode.totallylazy.matchers;

import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IterableMatcher<T> extends TypeSafeMatcher<Iterable<T>> {

    @SuppressWarnings("unchecked")
    public static Matcher<Iterable> hasSize(final Number size) {
        throw new RuntimeException("DAN");
        //return new HasSizeMatcher(size);
    }

    public static <T> Matcher<Iterable<T>> isEmpty() {
        return IterableMatcher.<T>hasExactly(Sequences.<T>empty());
    }

    public static <T> Matcher<Iterable<T>> hasExactly(Iterable<T> expected) {
        throw new RuntimeException("DAN");
        //return new IterableMatcher<T>(are(expected), true);
    }

    public static <T> Matcher<Iterable<T>> startsWith(Iterable<T> expected) {
        throw new RuntimeException("DAN");
    }
//
    @Override
    public boolean matchesSafely(Iterable<T> actual) {
       throw new RuntimeException("DAN");
    }

    public void describeTo(Description description) {
        throw new RuntimeException("DAN");
    }

}
