package creational.factory.factory_method.factory;

import creational.factory.factory_method.product.Circle;
import creational.factory.factory_method.product.Shape;

/**
 * 具体工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}