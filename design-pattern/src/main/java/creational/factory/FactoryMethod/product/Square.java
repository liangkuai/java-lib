package creational.factory.FactoryMethod.product;

/**
 * 具体产品类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}