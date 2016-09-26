package com.example.template;

/**
 * 行为型模式
 * 定义:定义一个操作中的算法框架,将一些步骤延迟到子类中,使得子类不改变算法的结构即可重定义算法的细节
 * 场景:多个子类有共有的方法,并且逻辑基本相同时;重要,复杂的算法可以把核心算法设计为模版方法,其余细节由子类实现;
 * 重构时常用,把相同的代码抽取到父类
 * Created by rgk on 16/9/26.
 */
public class TemplateClient {
    public static void main(String[] args) {
        AbsTemplate temp1 = new ConcreteTemplateA();
        temp1.execute();
        AbsTemplate temp2 = new ConcreteTemplateB();
        temp2.execute();
    }
}

/**
 * 定义一套算法框架
 */
abstract class AbsTemplate {
    void stepOne() {};
    void stepTwe() {};
    void stepThree() {};
    void stepFour() {};
    final void execute() {
        System.out.println("----start----");
        stepOne();
        stepTwe();
        stepThree();
        stepFour();
        System.out.println("----end----");
    };
}

class ConcreteTemplateA extends AbsTemplate{
    @Override
    void stepOne() {
        // // TODO: 16/9/26
    }

    @Override
    void stepTwe() {

    }

}

class ConcreteTemplateB extends AbsTemplate {

    @Override
    void stepThree() {

    }

    @Override
    void stepFour() {
        // // TODO: 16/9/26
    }
}