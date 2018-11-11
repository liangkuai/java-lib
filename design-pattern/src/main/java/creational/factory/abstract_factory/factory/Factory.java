package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.bullet.Bullet;
import creational.factory.abstract_factory.product.gun.Gun;

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
