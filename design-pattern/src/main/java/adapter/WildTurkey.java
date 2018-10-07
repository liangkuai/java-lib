package adapter;

/**
 * @author liangkuai
 * @date 2018/10/7
 */
public class WildTurkey implements Turkey {

    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
