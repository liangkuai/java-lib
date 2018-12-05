package creational.factory.factory_method.factory;

import creational.factory.factory_method.product.Shape;

/**
 * 抽象工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public interface Factory {
    public Shape getShape();
}
