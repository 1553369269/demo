package designPattern.singleton;

/**
 * @Description 单列模式
 * 概念：（Ensure a class has only one instance, and provide a global point of access to it）确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 * Author caihaojie
 * @Date 2020-04-09 11:01
 **/

//单例模式的优点

/**
 * 1、由于单例模式在内存中只有一个实例，减少了内存开支，特别是一个对象需要频繁地
 * 创建、销毁时，而且创建或销毁时性能又无法优化，单例模式的优势就非常明显。
 *
 * 2、由于单例模式只生成一个实例，所以减少了系统的性能开销，当一个对象的产生需要
 * 比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一 个单例对象，
 * 然后用永久驻留内存的方式来解决（在Java EE中采用单例模式时需要注意JVM垃圾回收机制）。
 *
 * 3、单例模式可以避免对资源的多重占用，例如一个写文件动作，由于只有一个实例存在
 * 内存中，避免对同一个资源文件的同时写操作。
 *
 * 4、单例模式可以在系统设置全局的访问点，优化和共享资源访问，例如可以设计一个单
 * 例类，负责所有数据表的映射处理。
  */

// 使用场景

/**
 * 1、要求生成唯一序列号的环境；
 *
 * 2、在整个项目中需要一个共享访问点或共享数据，例如一个Web页面上的计数器，可以
 * 不用把每次刷新都记录到数据库中，使用单例模式保持计数器的值，并确保是线程安全的；
 *
 * 3、 创建一个对象需要消耗的资源过多，如要访问IO和数据库等资源；
 *
 * 4、需要定义大量的静态常量和静态方法（如工具类）的环境，可以采用单例模式（当 然，也可以直接声明为static的方式）。
 */
public class Singleton {

    private static final Singleton SINGLETON = new Singleton();

    // 限制产生多个对象
    private Singleton(){}

    // 通过该方法获得实例对象
    public static Singleton getInstance(){
        return SINGLETON;
    }

    // 类中其他方法，尽量是static
    public static void doSomething(){

    }

}
