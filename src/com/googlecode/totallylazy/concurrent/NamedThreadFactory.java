package com.googlecode.totallylazy.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.String.format;

public class NamedThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable runnable) {
        throw new RuntimeException("DAN");
    }
}