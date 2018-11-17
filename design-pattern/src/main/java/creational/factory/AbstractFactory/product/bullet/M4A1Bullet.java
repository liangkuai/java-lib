package creational.factory.AbstractFactory.product.bullet;

/**
 * 具体产品
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class M4A1Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("Load bullets with AK");
    }
}
