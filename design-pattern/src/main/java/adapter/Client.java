package adapter;

/**
 * @author liangkuai
 * @date 2018/10/7
 */
public class Client {

    public static void main(String[] args) {

        Target target = new ConcreteTarget();
        System.out.println("无适配器：");
        target.chargeOf240V();
        System.out.println();

        Adaptee adaptee = new ConcreteAdaptee();
        Target adapter = new Adapter(adaptee);
        System.out.println("120V 充电器使用适配器：");
        adapter.chargeOf240V();
    }
}
