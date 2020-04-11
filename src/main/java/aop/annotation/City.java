package aop.annotation;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-27 14:32
 **/
@Entity(value = "city")
public class City {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
