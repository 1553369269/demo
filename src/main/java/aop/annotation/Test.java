package aop.annotation;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-27 14:35
 **/
public class Test {

    public static void main(String[] args) {
        City city = new City();
        city.setId(1);
        city.setName("TEST");
        String sql = Util.buildQuerySqlForEntity(city);
        // select * from city where id = 1 and name = 'test';
        System.out.println(sql);
    }

}
