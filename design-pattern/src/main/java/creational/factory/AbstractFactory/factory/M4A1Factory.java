package creational.factory.AbstractFactory.factory;

import creational.factory.AbstractFactory.product.bullet.Bullet;
import creational.factory.AbstractFactory.product.bullet.M4A1Bullet;
import creational.factory.AbstractFactory.product.gun.Gun;
import creational.factory.AbstractFactory.product.gun.M4A1;

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
