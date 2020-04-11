package designPattern.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-10 15:53
 **/
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 这个就是我们要代理的真实对象
     */
    private Object subject;

    /**
     * 构造方法，给我们要代理的真实对象赋初值
     *
     * @param subject
     */
    public InvocationHandlerImpl(Object subject)
    {
        this.subject = subject;
    }


    /**
     * 该方法负责集中处理动态代理类上的所有方法调用。
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy 代理类实例
     * @param method 被调用的方法对象
     * @param args 调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用之前的操作
        System.out.println("前-----------");
        // 方法执行
        method.invoke(subject,args);
        // 调用之后的操作
        System.out.println("后-------------");
        return null;
    }
}
