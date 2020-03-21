package creational.factory.abstract_factory;


import creational.factory.abstract_factory.factory.AppleFactory;
import creational.factory.abstract_factory.factory.Factory;
import creational.factory.abstract_factory.product.laptop.Laptop;
import creational.factory.abstract_factory.product.phone.Phone;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {

    public static void main(String[] args) {
        Factory factory;

        Phone phone;
        Laptop laptop;

        factory =new AppleFactory();

        phone=factory.producePhone();
        phone.sendMessage();

        laptop=factory.produceLaptop();
        laptop.start();
    }
}