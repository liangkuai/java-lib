package creational.factory.AbstractFactory.factory;

import creational.factory.AbstractFactory.product.bullet.Bullet;
import creational.factory.AbstractFactory.product.gun.Gun;

/**
 * 抽象工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public interface Factory {
    Gun produceGun();
    Bullet produceBullet();
}
