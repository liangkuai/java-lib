package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.laptop.ChromeBook;
import creational.factory.abstract_factory.product.laptop.Laptop;
import creational.factory.abstract_factory.product.phone.IPhone;
import creational.factory.abstract_factory.product.phone.Phone;

/**
 * 具体工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class GoogleFactory implements Factory {

    @Override
    public Phone producePhone() {
        return new IPhone();
    }

    @Override
    public Laptop produceLaptop() {
        return new ChromeBook();
    }
}
