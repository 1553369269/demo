package jdkProxy;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-30 10:26
 **/
public interface CoustomInvocationHandler {

    public Object invoke(Method method);
}
