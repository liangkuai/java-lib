package behavioral.TemplateMethod;

/**
 * @author liangkuai
 * @date 2018/11/16
 */
public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
