package designPattern.proxyPattern.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-13 11:10
 **/

/**
 * 原理
 *
 * 代理对象继承于HelloService，拦截器调用intercept()方法，
 *
 * intercept()方法由自定义MyMethodInterceptor实现，所以，最后调用MyMethodInterceptor中
 *
 * 的intercept()方法，从而完成了由代理对象访问到目标对象的动态代理实现。
 */
public class Client {
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }
}
