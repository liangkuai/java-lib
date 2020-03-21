package behavioral.strategy;

/**
 * @author liangkuai
 * @date 2018/11/17
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
