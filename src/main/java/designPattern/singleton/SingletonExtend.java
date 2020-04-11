package designPattern.singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description 单列模式的扩展，产生固定数量的实例
 * Author caihaojie
 * @Date 2020-04-09 11:18
 **/
public class SingletonExtend {

    // 定义最多能产生的实例数量
    private static int maxNum = 2;
    // 创建一个list，用来存储对象的名字
    private static ArrayList<String> nameList=new ArrayList<String>();
    // 容纳所有SingletonExtend的实例
    private static ArrayList<SingletonExtend> singletonExtends=new ArrayList<SingletonExtend>();
    // 当前实例的序列号
    private static int countNum = 0;
    // 产生所有的对象
    static {
        for (int i = 0;i < maxNum;i++) {
            singletonExtends.add(new SingletonExtend("实例" + (i + 1)));
        }
    }

    private SingletonExtend(){}

    // 传入实例名称，创建一个实例
    private SingletonExtend(String name){
        nameList.add(name);
    }

    // 随机获得一个实例
    public static SingletonExtend getInstance(){
        Random random = new Random();
        countNum = random.nextInt(maxNum);
        return singletonExtends.get(countNum);
    }

    // 看看是哪个实例
    public static void say() {
        System.out.println(nameList.get(countNum));
    }


}
