package myspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
