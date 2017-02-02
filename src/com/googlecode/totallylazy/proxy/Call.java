package com.googlecode.totallylazy.proxy;

import com.googlecode.totallylazy.Unchecked;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

//import static com.googlecode.totallylazy.proxy.Proxy.createProxy;

public class Call<T,R> implements InvocationHandler{
    //public static ThreadLocalInvocation invocation = new ThreadLocalInvocation();

    private Call() {}

    public static <T> T on(Class<T> aCLass){
        throw new RuntimeException("DAN");
         //return createProxy(aCLass, new Call());
    }

    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        throw new RuntimeException("DAN");
        //invocation.set(new MethodInvocation<T,R>(method, arguments));
        //return null;
    }

    public static <T, S> Invocation<T, S> method(S value){
        throw new RuntimeException("DAN");
        //return Unchecked.cast(invocation.get());
    }
}
