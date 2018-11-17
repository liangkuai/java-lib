package behavioral.Strategy;

/**
 * @author liangkuai
 * @date 2018/11/17
 */
public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();

        duck.setQuackBehavior(new Squeak());
        duck.performQuack();

        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
