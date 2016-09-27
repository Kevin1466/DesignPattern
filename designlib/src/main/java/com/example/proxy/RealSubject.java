package com.example.proxy;

import com.example.proxy.dynamicproxy.ISubject;

/**
 * Created by rgk on 16/9/27.
 */
public class RealSubject implements ISubject {
    @Override
    public void doSomething() {
        System.out.println("this is real subject, doing something");
    }
}
