package com.googlecode.totallylazy.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class NumberMatcher extends TypeSafeMatcher<Number> {
    private final Number other;

    public NumberMatcher(Number other) {
        this.other = other;
    }

    public void describeTo(Description description) {
        description.appendValue(other);
    }

    @Override
    protected boolean matchesSafely(Number number) {
        throw new RuntimeException("DAN");
    }

    public static Matcher<Number> greaterThanOrEqualTo(final Number other) {
        throw new RuntimeException("DAN");
    }

}
