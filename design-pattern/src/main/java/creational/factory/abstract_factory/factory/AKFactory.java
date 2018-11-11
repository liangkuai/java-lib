package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.bullet.AKBullet;
import creational.factory.abstract_factory.product.bullet.Bullet;
import creational.factory.abstract_factory.product.gun.AK;
import creational.factory.abstract_factory.product.gun.Gun;

/**
 * 具体工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class AKFactory implements Factory {

    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AKBullet();
    }
}
