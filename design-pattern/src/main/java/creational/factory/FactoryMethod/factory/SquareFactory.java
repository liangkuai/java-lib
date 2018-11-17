package creational.factory.FactoryMethod.factory;

import creational.factory.FactoryMethod.product.Shape;
import creational.factory.FactoryMethod.product.Square;

/**
 * 具体工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}