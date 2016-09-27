package com.example.mediator;

/**
 * 行为型
 * 定义:包装了一系列对象相互作用的方式,将多对多的相互作用转化为一对多的相互作用
 * 场景:当对象之间的交互操作很多且每个对象的行为操作都依赖彼此时,为防止在修改一个对象的行为时,同时涉及修改很多其他对象的行为
 * Created by rgk on 16/9/27.
 */
public class MediatorClient {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.setConcreteColleageA(new ConcreteColleageA(mediator));
        mediator.setConcreteColleageB(new ConcreteColleageB(mediator));
        mediator.method();
    }
}

abstract class Colleage {
    protected Mediator mediator;

    public Colleage(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void action();
}

abstract class Mediator {
    protected ConcreteColleageA concreteColleageA;
    protected ConcreteColleageB concreteColleageB;

    public void setConcreteColleageA(ConcreteColleageA concreteColleageA) {
        this.concreteColleageA = concreteColleageA;
    }

    public void setConcreteColleageB(ConcreteColleageB concreteColleageB) {
        this.concreteColleageB = concreteColleageB;
    }

    abstract void method();
}

class ConcreteColleageA extends Colleage {
    @Override
    void action() {
        System.out.println("Colleage A 将信息递交给中介者处理");
    }

    public ConcreteColleageA(Mediator mediator) {
        super(mediator);
    }
}

class ConcreteColleageB extends Colleage {
    public ConcreteColleageB(Mediator mediator) {
        super(mediator);
    }

    @Override
    void action() {
        System.out.println("Colleage B 将信息递交给中介者处理");
    }
}

class ConcreteMediator extends Mediator {

    @Override
    void method() {
        concreteColleageA.action();
        concreteColleageA.action();
    }
}