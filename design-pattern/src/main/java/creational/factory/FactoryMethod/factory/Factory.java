package creational.factory.FactoryMethod.factory;

import creational.factory.FactoryMethod.product.Shape;

/**
 * 抽象工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public interface Factory {
    public Shape getShape();
}
