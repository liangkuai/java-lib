package creational.factory.abstract_factory.product.phone;

/**
 * 具体产品
 *
 * @author liangkuai
 * @date 2018/11/11
 */
public class IPhone implements Phone {

    @Override
    public void sendMessage() {
        System.out.println("shooting with IPhone");
    }
}