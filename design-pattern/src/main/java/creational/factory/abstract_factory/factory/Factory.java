package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.laptop.Laptop;
import creational.factory.abstract_factory.product.phone.Phone;

/**
 * 抽象工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public interface Factory {
    Laptop produceLaptop();

    Phone producePhone();
}
