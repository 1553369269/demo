package aop.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-27 14:40
 **/
@Target(ElementType.TYPE) // 表示@Entity的目标位置只能够是类（只能写在类上），
                           // 可以指定多个{ElementType.FIELD,ElementType.TYPE},表示可以写在类或者属性上面

@Retention(RetentionPolicy.RUNTIME) // 自定义注解的生命周期,RetentionPolicy.SOURCE 表示只存在源代码中，不会参与编译
                                   // RetentionPolicy.CLASS 只存在在class文件当中，jvm运行的时候会被忽略
                                    // RetentionPolicy.RUNTIME jvm执行的时候会被运行到
public @interface Entity {
    public String value() default "";
}
