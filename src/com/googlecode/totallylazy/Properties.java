package com.googlecode.totallylazy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.googlecode.totallylazy.Sequences.sequence;
import static java.lang.String.format;

public class Properties {
    public static java.util.Properties properties(InputStream stream) throws IOException {
        throw new RuntimeException("DAN");
    }

    public static java.util.Properties properties(Iterable<Pair<String, String>> values) {
        throw new RuntimeException("DAN");

    }
//
    public static java.util.Properties properties(Pair<String, String>... values) {
        return properties(sequence(values));
    }
//
    public static java.util.Properties copy(Map properties) {
        throw new RuntimeException("DAN");
        //return properties(pairs(properties));
    }

    public static Sequence<Pair<String, String>> pairs(Map properties){
        return Maps.pairs(Unchecked.<Map<String, String>>cast(properties));
    }
//
    public static java.util.Properties compose(java.util.Properties... properties) {
        throw new RuntimeException("DAN");
        //return compose(sequence(properties));
    }

}
