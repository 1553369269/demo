package designPattern.proxyPattern;

/**
 * @Description 被代理类(目标类)
 * Author caihaojie
 * @Date 2020-04-10 14:58
 **/
public class RealSubject implements Subject{
    @Override
    public void request() {
        // 业务逻辑处理
        System.out.println("调用了");
    }
}
