package creational.factory.FactoryMethod;

import creational.factory.FactoryMethod.factory.CircleFactory;
import creational.factory.FactoryMethod.factory.Factory;
import creational.factory.FactoryMethod.product.Shape;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {
    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape circle = circleFactory.getShape();
        circle.draw();
    }
}