package aop.annotation;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-27 14:33
 **/
public class Util {
    /**
     * 通过一个对象构建一条sql语句
     * @param obj
     */
    public static String buildQuerySqlForEntity(Object obj){
        Class clazz = obj.getClass();
        String entityName = "";

        // setup1 判断是否加了这个注解
        if (clazz.isAnnotationPresent(Entity.class)) {
            // setup2 得到注解
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
            // setup3 调用方法
            entityName = entity.value();

        }
        String sql = "select * from " + entityName;
        return sql;
    }
}
