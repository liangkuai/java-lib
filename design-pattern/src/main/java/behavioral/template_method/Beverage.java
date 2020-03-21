package behavioral.template_method;

/**
 * @author liangkuai
 * @date 2018/11/16
 */
public abstract class Beverage {

    /**
     * 模板方法
     *
     * 定义了算法框架
     */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("boilWater");
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }

    protected abstract void brew();

    protected abstract void addCondiments();
}