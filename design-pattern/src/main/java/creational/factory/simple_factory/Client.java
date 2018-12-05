package creational.factory.simple_factory;

import creational.factory.simple_factory.product.Shape;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {

    public static void main(String[] args) {
        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }
}
