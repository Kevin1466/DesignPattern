package com.example.singleton;

/**
 * Created by rgk on 16/9/26.
 */
public class SingletonClient {
    public static void main(String[] args) {

    }
}

/**
 * 懒汉式
 */
class SingletonLazy {
    private static SingletonLazy instance = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null)
            instance = new SingletonLazy();
        return instance;
    }
}

/**
 * 饿汉式
 */
class SingletonHunger {
    private static SingletonHunger instance = new SingletonHunger();

    public SingletonHunger() {
    }

    public static SingletonHunger getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new SingletonHunger();
        }
    }
}

/**
 * double checklock
 */
class SingletonDCL {
    private static SingletonDCL instance = null;

    public SingletonDCL() {
    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null)
                    instance = new SingletonDCL();
            }
        }
        return instance;
    }
}

/**
 * 静态内部类实现
 */
class SingletonStatic {

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance() {
        return SingletonStaticHolder.sInstance;
    }

    private static class SingletonStaticHolder {
        private static final SingletonStatic sInstance = new SingletonStatic();
    }
}

/**
 * 枚举实现
 */
enum SingletonEnum {
    INSTANCE;
    public void doSomething() {
        // // TODO: 16/9/26
    }
}

/**
 * 容器实现
 */
class SingleManager {

}