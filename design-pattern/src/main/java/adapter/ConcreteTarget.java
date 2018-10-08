package adapter;

/**
 * 具体目标类
 *
 * @author liangkuai
 * @date 2018/10/7
 */
public class ConcreteTarget implements Target {

    @Override
    public void chargeOf240V() {
        System.out.println("240V 充电器");
    }
}
