package creational.factory.simple_factory.product;

/**
 * 具体产品类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class MacBook implements Laptop {
    public MacBook() {
        System.out.println("MacBook");
    }

    @Override
    public void start() {
        System.out.println("start MacBook");
    }
}