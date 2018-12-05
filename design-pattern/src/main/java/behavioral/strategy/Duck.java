package behavioral.strategy;

/**
 * @author liangkuai
 * @date 2018/11/17
 */
public class Duck {

    private QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }
}