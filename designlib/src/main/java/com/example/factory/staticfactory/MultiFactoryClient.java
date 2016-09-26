package com.example.factory.staticfactory;

/**
 * Created by rgk on 16/9/26.
 */

public class MultiFactoryClient {
    public static void main(String[] a) {
        MFactory factory = new MConcreteFactory();
        factory.createProduct(MConcreteProduct.class);
    }
}

class MConcreteFactory extends MFactory {
    @Override
    <T extends MProduct> T createProduct(Class<T> clz) {
        MProduct product = null;
        try {
            product = (MProduct) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}

class MConcreteProduct extends MProduct {
    @Override
    public void method() {

    }
}

abstract class MProduct {
    abstract void method();
}

abstract class MFactory {
    // 根据参数类型产生产品
    abstract <T extends MProduct> T createProduct(Class<T> clz);
}
