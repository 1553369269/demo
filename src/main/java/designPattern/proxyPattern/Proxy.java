package designPattern.proxyPattern;

/**
 * @Description 代理类
 * Author caihaojie
 * @Date 2020-04-10 14:59
 **/
public class Proxy implements Subject{
    // 要代理哪个实现类
    private Subject subject = null;
    // 默认目标类
    public Proxy () {
        this.subject = new Proxy();
    }
    // 通过构造函数转递目标对象
    public Proxy(Object...objects){

    }
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    //预处理
    private void before(){
        //do something
    }
    //善后处理
    private void after(){
        //do something
    }
}
