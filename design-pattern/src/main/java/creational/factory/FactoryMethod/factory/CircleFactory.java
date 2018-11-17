package creational.factory.FactoryMethod.factory;

import creational.factory.FactoryMethod.product.Circle;
import creational.factory.FactoryMethod.product.Shape;

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