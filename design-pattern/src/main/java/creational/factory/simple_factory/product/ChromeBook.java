package creational.factory.simple_factory.product;

/**
 * 具体产品类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class ChromeBook implements Laptop {
    public ChromeBook() {
        System.out.println("ChromeBook");
    }

    @Override
    public void start() {
        System.out.println("start ChromeBook");
    }
}