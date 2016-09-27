package com.example.proxy.staticproxy;

import com.example.proxy.RealSubject;

/**
 * 行为型
 * 定义:为其他对象提供一种代理以控制对这个对象的访问
 * 场景:当不想/无法直接访问某个对象时可通过代理对象来间接访问
 * Created by rgk on 16/9/27.
 */
public class ProxyClient {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        realSubject.doSomething();
    }
}

class ProxySubject extends SSubject {
    RealSubject realSubject;
    @Override
    public void doSomething() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.doSomething();
    }
}

abstract class SSubject {
    abstract void doSomething();
}
