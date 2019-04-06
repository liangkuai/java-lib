package creational.factory.factory_method.factory;

import creational.factory.factory_method.product.Laptop;
import creational.factory.factory_method.product.MacBook;

/**
 * 具体工厂类
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class MacBookFactory implements LaptopFactory {
    @Override
    public Laptop getLaptop() {
        return new MacBook();
    }
}