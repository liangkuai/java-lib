package creational.factory.factory_method;

import creational.factory.factory_method.factory.LaptopFactory;
import creational.factory.factory_method.factory.MacBookFactory;
import creational.factory.factory_method.product.Laptop;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {
    public static void main(String[] args) {
        LaptopFactory appleFactory = new MacBookFactory();
        Laptop macBook = appleFactory.getLaptop();
        macBook.start();
    }
}