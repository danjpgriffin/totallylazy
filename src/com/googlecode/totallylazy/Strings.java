package com.googlecode.totallylazy;
import java.io.InputStream;


public class Strings {
    public static Sequence<String> lines(InputStream stream) {
        throw new RuntimeException("DAN");
    }

    public static boolean isEmpty(String value) {
        throw new RuntimeException("DAN");
        //return value == null || value.equals(EMPTY);
    }
//
    public static boolean isBlank(String value) {
        throw new RuntimeException("DAN");
        //return isEmpty(value) || isEmpty(value.trim());
    }

    public static String asString(Object value) {
        return value == null ? "" : value.toString();
    }

    public static String string(InputStream value) {
        throw new RuntimeException("DAN");
        //return toString(value);
    }

    public static Function1<CharSequence, Sequence<Character>> toCharacters() {
        throw new RuntimeException("DAN");

    }

    public static Function1<String, Sequence<String>> split(final String regex) {
        throw new RuntimeException("DAN");

    }

}