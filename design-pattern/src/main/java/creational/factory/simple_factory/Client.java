package creational.factory.simple_factory;

import creational.factory.simple_factory.product.Laptop;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {

    public static void main(String[] args) {
        // 获取 ChromeBook 的对象
        Laptop chromeBook = LaptopFactory.getLaptop("Apple");
        chromeBook.start();

        // 获取 MacBook 的对象
        Laptop macBook = LaptopFactory.getLaptop("Google");
        macBook.start();
    }
}
