package creational.factory.simple_factory;

import creational.factory.simple_factory.product.ChromeBook;
import creational.factory.simple_factory.product.Laptop;
import creational.factory.simple_factory.product.MacBook;

/**
 * 具体工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class LaptopFactory {

    /**
     * 静态工厂方法
     *
     * 根据参数判断创建哪种对象
     */
    public static Laptop getLaptop(String brand) {
        if (brand == null) {
            return null;
        }

        if (brand.equals("Google")) {
            return new ChromeBook();
        } else if (brand.equals("Apple")) {
            return new MacBook();
        }
        return null;
    }
}
