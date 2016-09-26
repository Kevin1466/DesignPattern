package com.example.builder;

/**
 * 创建型模式
 * 定义:将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示
 * 场景:不同的执行顺序;多个部件;产品类复杂;初始化一个对象特别复杂,如参数多,且很多有默认值时
 * Created by rgk on 16/9/26.
 */
public class BuilderClient {
    Builder builder = null;

    public BuilderClient(Builder builder) {
        this.builder = builder;
    }

    public static void main(String[] agrs) {
        BuilderClient client = new BuilderClient(new ConcreteBuilder());
        Builder builder = client.builder;
        builder.buildPartA();
        builder.buildPartC();
        builder.build();
    }
}

abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract Procuct build();
}

class ConcreteBuilder extends Builder {

    private Procuct mProcuct = new Procuct();

    @Override
    public Procuct build() {
        return mProcuct;
    }

    @Override
    public void buildPartA() {
        mProcuct.setA("A");
    }

    @Override
    public void buildPartB() {
        mProcuct.setB(2);
    }

    @Override
    public void buildPartC() {
        mProcuct.setC("C");
    }
}

class Procuct {
    private String A, B, C;
    private int a, b , c;

    public void setA(String a) {
        A = a;
    }

    public void setB(String b) {
        B = b;
    }

    public void setC(String c) {
        C = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }
}

