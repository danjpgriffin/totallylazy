package com.googlecode.totallylazy.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class NamedExecutors {

    public static ThreadFactory namedThreadFactory(Class<?> creatingClass) {
        throw new RuntimeException("DAN");
    }

    public static ExecutorService newCachedThreadPool(Class<?> creatingClass) {
        throw new RuntimeException("DAN");
    }

}