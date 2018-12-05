package behavioral.template_method;

/**
 * @author liangkuai
 * @date 2018/11/16
 */
public class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}
