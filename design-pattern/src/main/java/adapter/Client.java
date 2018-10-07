package adapter;

/**
 * @author liangkuai
 * @date 2018/10/7
 */
public class Client {

    public static void main(String[] args) {

        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
