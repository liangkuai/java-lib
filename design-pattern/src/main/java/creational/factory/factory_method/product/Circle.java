package creational.factory.factory_method.product;

/**
 * 具体产品类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}