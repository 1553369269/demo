package designPattern.singleton;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-09 11:08
 **/
public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3;i ++) {
            Singleton singleton = Singleton.getInstance();
            // 打印的hashCode值相同，说明只产生了一个实例
            System.out.println(singleton.hashCode());
        }
    }

}
