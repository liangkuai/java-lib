package proxy.statics;

import proxy.Subject;

/**
 * 静态代理类
 *
 * @author liukai
 * @date 2020-12-11
 */
public class StaticProxy implements Subject {

    // 被代理对象
    private Subject subject;

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething()，前置代理逻辑");
        subject.doSomething();
        System.out.println("doSomething()，后置代理逻辑");
    }

    @Override
    public void doSomething2() {
        System.out.println("doSomething2()，前置代理逻辑");
        subject.doSomething();
        System.out.println("doSomething2()，后置代理逻辑");
    }

}
