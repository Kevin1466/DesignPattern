package com.example.facade;

/**
 * 行为型
 * 定义:要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行,Facade提供一个高层次的接口,使得子系统易于使用
 * 场景:隐藏子系统具体实现;
 * Created by rgk on 16/9/26.
 */
public class FacadeClient {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operationA();
        facade.operationB();
        facade.operationC();
    }
}

class Facade {
    private SystemA mSystemA;
    private SystemB mSystemB;
    private SystemC mSystemC;

    void operationA() {
        mSystemA.operA();
        mSystemB.operB();
    }
    void operationB() {
        mSystemB.operB();
        mSystemC.operC();
    }
    void operationC() {}
}

interface SystemA {
    void operA();
}

interface SystemB {
    void operB();
}

interface SystemC {
    void operC();
}
