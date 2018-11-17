package behavioral.Strategy;

/**
 * @author liangkuai
 * @date 2018/11/17
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
