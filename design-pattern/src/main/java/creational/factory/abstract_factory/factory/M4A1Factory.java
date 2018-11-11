package creational.factory.abstract_factory.factory;

import creational.factory.abstract_factory.product.bullet.Bullet;
import creational.factory.abstract_factory.product.bullet.M4A1Bullet;
import creational.factory.abstract_factory.product.gun.Gun;
import creational.factory.abstract_factory.product.gun.M4A1;

/**
 * 具体工厂
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class M4A1Factory implements Factory {

    @Override
    public Gun produceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1Bullet();
    }
}
