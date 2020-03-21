package creational.factory.factory_method.factory;

import creational.factory.factory_method.product.ChromeBook;
import creational.factory.factory_method.product.Laptop;

/**
 * 具体工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class ChromeBookFactory implements LaptopFactory {
    @Override
    public Laptop getLaptop() {
        return new ChromeBook();
    }
}