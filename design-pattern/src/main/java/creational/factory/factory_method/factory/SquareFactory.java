package creational.factory.factory_method.factory;

import creational.factory.factory_method.product.Shape;
import creational.factory.factory_method.product.Square;

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