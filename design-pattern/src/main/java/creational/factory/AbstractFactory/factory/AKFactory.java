package creational.factory.AbstractFactory.factory;

import creational.factory.AbstractFactory.product.bullet.AKBullet;
import creational.factory.AbstractFactory.product.bullet.Bullet;
import creational.factory.AbstractFactory.product.gun.AK;
import creational.factory.AbstractFactory.product.gun.Gun;

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
