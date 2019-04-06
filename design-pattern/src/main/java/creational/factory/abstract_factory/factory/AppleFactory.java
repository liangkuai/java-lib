package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.laptop.Laptop;
import creational.factory.abstract_factory.product.laptop.MacBook;
import creational.factory.abstract_factory.product.phone.Android;
import creational.factory.abstract_factory.product.phone.Phone;

/**
 * 具体工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class AppleFactory implements Factory {

    @Override
    public Phone producePhone() {
        return new Android();
    }

    @Override
    public Laptop produceLaptop() {
        return new MacBook();
    }
}
