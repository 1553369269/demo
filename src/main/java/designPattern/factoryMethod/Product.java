package designPattern.factoryMethod;

/**
 * @Description 工厂方法设计模式
 * Define an interface for creating an object,but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.
 * 概念:定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类
 * Author caihaojie
 * @Date 2020-04-09 13:50
 **/
// 抽象产品类
public abstract class Product {
    // 产品类的公共方法
    public void method1(){
        // 业务逻辑
    }
    // 抽象方法
    public abstract void method2();
}
