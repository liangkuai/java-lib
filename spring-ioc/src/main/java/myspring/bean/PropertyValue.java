package myspring.bean;

/**
 * bean 的属性
 *
 * @author liangkuai
 * @date 2018/11/18
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
