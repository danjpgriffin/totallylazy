package com.googlecode.totallylazy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

//import static com.googlecode.totallylazy.Strings.EMPTY;

@SuppressWarnings("unused")
public class URLs {

    public static URL url(final String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw LazyException.lazyException(e);
        }
    }

}