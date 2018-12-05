package creational.factory.abstract_factory;


import creational.factory.abstract_factory.factory.AKFactory;
import creational.factory.abstract_factory.factory.Factory;
import creational.factory.abstract_factory.product.bullet.Bullet;
import creational.factory.abstract_factory.product.gun.Gun;

/**
 * @author liangkuai
 * @date 2018/11/11
 */
public class Client {

    public static void main(String[] args) {
        Factory factory;
        Gun gun;
        Bullet bullet;

        factory =new AKFactory();

        gun=factory.produceGun();
        gun.shooting();

        bullet=factory.produceBullet();
        bullet.load();
    }
}