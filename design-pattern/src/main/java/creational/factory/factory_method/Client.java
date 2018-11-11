package creational.factory.factory_method;

import creational.factory.factory_method.factory.CircleFactory;
import creational.factory.factory_method.factory.Factory;
import creational.factory.factory_method.product.Shape;

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