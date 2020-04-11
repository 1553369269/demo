package jdkProxy;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-30 10:33
 **/
public class TestJdkProxyDaoImpl implements TestJdkProxyDao{
    @Override
    public String proxy() throws Exception {
        System.out.println("aaaaaaaaaaa");
        return "proxy";
    }
}
