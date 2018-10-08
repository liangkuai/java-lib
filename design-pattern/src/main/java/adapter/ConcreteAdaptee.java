package adapter;

/**
 * 具体被适配类
 *
 * @author liangkuai
 * @date 2018/10/7
 */
public class ConcreteAdaptee implements Adaptee {

    @Override
    public void chargeOf120V() {
        System.out.println("120V 充电器");
    }
}
