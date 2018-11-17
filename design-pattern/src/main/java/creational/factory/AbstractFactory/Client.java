package creational.factory.AbstractFactory;


import creational.factory.AbstractFactory.factory.AKFactory;
import creational.factory.AbstractFactory.factory.Factory;
import creational.factory.AbstractFactory.product.bullet.Bullet;
import creational.factory.AbstractFactory.product.gun.Gun;

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