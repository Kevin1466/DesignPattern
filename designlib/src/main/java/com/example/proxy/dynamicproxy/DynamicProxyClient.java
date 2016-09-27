package com.example.proxy.dynamicproxy;

import com.example.proxy.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * Created by rgk on 16/9/27.
 */
public class DynamicProxyClient {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        // 构造一个动态代理
        DynamicProxy proxy = new DynamicProxy(realSubject);
        // 获取被代理类的ClassLoader
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        // 动态构造一个代理者
        ISubject subject = (ISubject)Proxy.newProxyInstance(classLoader, new Class[] {ISubject.class}, proxy);
        subject.doSomething();
    }
}

class DynamicProxy implements InvocationHandler {
    private Object realSubject;    // 被代理者的引用,注意是Object类型

    public DynamicProxy(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(realSubject, args);
    }
}
