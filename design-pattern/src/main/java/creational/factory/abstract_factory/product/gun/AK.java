package creational.factory.abstract_factory.product.gun;

/**
 * 具体产品
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class AK implements Gun{

    @Override
    public void shooting() {
        System.out.println("shooting with AK");
    }
}