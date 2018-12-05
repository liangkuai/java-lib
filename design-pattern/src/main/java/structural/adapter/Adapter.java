package structural.adapter;

/**
 * 适配器
 *
 * @author liangkuai
 * @date 2018/10/7
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void chargeOf240V() {
        adaptee.chargeOf120V();
        System.out.println("适配器转换......");
        System.out.println("240V 充电器");
    }
}
