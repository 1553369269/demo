package jdkProxy;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-30 10:46
 **/
public class Test {

    public static void main(String[] args) {
        // 自定义的Java 动态代理
        TestJdkProxyDao proxy = (TestJdkProxyDao) ProxyUtil.newInstance(TestJdkProxyDao.class, new TestCustomHandler(new TestJdkProxyDaoImpl()));
        try{
            proxy.proxy();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
