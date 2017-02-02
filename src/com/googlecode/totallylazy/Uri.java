package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.regex.Regex;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.regex.MatchResult;

//import static com.googlecode.totallylazy.Strings.isEmpty;

public class Uri implements Comparable<Uri> {

    public Uri(CharSequence value) {

    }

    public static Uri uri(CharSequence value) {
        throw new RuntimeException("DAN");
        //return new Uri(value);
    }

    public static Uri uri(URI value) {
        return new Uri(value.toString());
    }

    public String scheme() {
        throw new RuntimeException("DAN");
        //return scheme;
    }

    public Uri scheme(String value) {
        throw new RuntimeException("DAN");
        //return new Uri(value, authority, path, query, fragment);
    }
//
    public Uri dropScheme() {
        throw new RuntimeException("DAN");
        //return scheme(null);
    }
//
    public String authority() {
        throw new RuntimeException("DAN");
        //return authority;
    }

    public Uri dropAuthority() {
        throw new RuntimeException("DAN");
        //return authority(null);
    }

    public Uri dropUserInfo() {
        throw new RuntimeException("DAN");
        //return userInfo(null);
    }
//
    public String host() {
        throw new RuntimeException("DAN");
        //return Authority().host();
    }

    public Uri host(String value) {
        throw new RuntimeException("DAN");
        //return Authority(Authority().host(value));
    }
//
    public Uri dropHost() {
        throw new RuntimeException("DAN");
        //return host(null);
    }
//
    public int port() {
        throw new RuntimeException("DAN");
        //return Authority().port();
    }

    public Uri port(int value) {
        throw new RuntimeException("DAN");
        //return Authority(Authority().port(value));
    }
//
    public Uri dropPort() {
        return port(-1);
    }
//
    public String path() {
        throw new RuntimeException("DAN");
        //return path;
    }

    public Uri path(String value) {
        throw new RuntimeException("DAN");
        //return new Uri(scheme, authority, value, query, fragment);
    }

    public Uri mergePath(String value) {
        throw new RuntimeException("DAN");

    }
//
    public String query() {
        throw new RuntimeException("DAN");
        //return query;
    }
//
    public Uri query(String value) {
        throw new RuntimeException("DAN");
        //return new Uri(scheme, authority, path, value, fragment);
    }
//
    public Uri dropQuery() {
        throw new RuntimeException("DAN");
        //return query(null);
    }
//
    public String fragment() {
        throw new RuntimeException("DAN");
        //return fragment;
    }

    public Uri dropFragment() {
        throw new RuntimeException("DAN");
        //return fragment(null);
    }

    public URL toURL() {
        return URLs.url(toString());
    }
//
    public URI toURI() {
        throw new RuntimeException("DAN");
        //return URLs.uri(toString());
    }

    @Override
    public int compareTo(Uri other) {
        return toString().compareTo(other.toString());
    }

    public Uri removeDotSegments() {
        throw new RuntimeException("DAN");
//        if(Strings.isEmpty(path)) return this;
//        return path(DotSegments.remove(path));
    }

}