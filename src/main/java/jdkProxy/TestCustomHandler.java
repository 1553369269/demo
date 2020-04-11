package jdkProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-30 10:29
 **/
public class TestCustomHandler implements CoustomInvocationHandler{
    // 目标对象
    Object target;

    public TestCustomHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Method method) {
        try {
            System.out.println("----------------");
            // 执行目标对象中的方法
            return  method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
