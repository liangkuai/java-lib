package creational.factory.AbstractFactory.product.gun;

/**
 * 具体产品
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class M4A1 implements Gun {

    @Override
    public void shooting() {
        System.out.println("shooting with M4A1");
    }
}