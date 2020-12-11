package proxy;

/**
 * 被代理类
 *
 * @author liukai
 * @date 2020-12-11
 */
public class RealSubject implements Subject {

    public void doSomething() {
        System.out.println("call doSomething()");
    }

    public void doSomething2() {
        System.out.println("call doSomething2()");
    }

}
