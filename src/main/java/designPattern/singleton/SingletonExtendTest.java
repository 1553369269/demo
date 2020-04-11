package designPattern.singleton;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-09 11:34
 **/
public class SingletonExtendTest {

    public static void main(String[] args) {
        for (int i = 0;i < 5; i++) {
            SingletonExtend singletonExtend = SingletonExtend.getInstance();
            singletonExtend.say();
        }
    }

}
