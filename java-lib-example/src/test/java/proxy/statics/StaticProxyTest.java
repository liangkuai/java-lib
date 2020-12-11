package proxy.statics;

import org.junit.Test;
import proxy.RealSubject;
import proxy.Subject;

import static org.junit.Assert.*;

/**
 * @author liukai
 * @date 2020-12-11
 */
public class StaticProxyTest {

    @Test
    public void doSomethingTest() {
        Subject proxyObj = new StaticProxy(new RealSubject());
        proxyObj.doSomething();
    }

}