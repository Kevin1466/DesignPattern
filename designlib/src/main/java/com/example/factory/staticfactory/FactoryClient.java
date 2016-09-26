package com.example.factory.staticfactory;

/**
 * 创建型模式
 * 描述:定义一个用于创建对象的接口,让子类决定实例化哪个类
 * 场景:适用于在任何需要生成复杂对象的地方
 * Created by rgk on 16/9/26.
 */
public class FactoryClient {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        Product product = factory.createProduct();
        product.method();
    }
}

abstract class Factory {
    abstract Product createProduct();
}

abstract class Product {
    public abstract void method();
}

class ConcreteFactoryA extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductA extends Product {

    @Override
    public void method() {

    }
}
