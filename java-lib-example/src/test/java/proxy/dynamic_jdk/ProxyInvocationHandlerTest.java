package proxy.dynamic_jdk;

import org.junit.Test;
import proxy.RealSubject;
import proxy.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * @author liukai
 * @date 2020-12-11
 */
public class ProxyInvocationHandlerTest {

    @Test
    public void doSomethingTest() {
        // 1. 创建被代理对象
        Subject subject = new RealSubject();

        // 2. 创建代理类的调用处理器
        InvocationHandler invocationHandler = new ProxyInvocationHandler(subject);

        // 3. 生成代理对象
        Subject proxyObj = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                invocationHandler);

        // 4. 调用代理对象的方法
        proxyObj.doSomething();
    }

    @Test
    public void doSomething2Test() throws Exception {
        // 1. 创建被代理对象
        Subject subject = new RealSubject();

        // 2. 创建代理类的调用处理器
        InvocationHandler invocationHandler = new ProxyInvocationHandler(subject);

        // 3. 生成代理类的 Class 对象
        Class<?> proxyClass = Proxy.getProxyClass(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces());

        // 4. 获取代理类的构造器，代理类的调用处理器作为参数
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);

        // 5. 使用代理类的构造器生成代理对象
        Subject proxyObj = (Subject) constructor.newInstance(invocationHandler);

        // 6. 调用代理对象的方法
        proxyObj.doSomething2();
    }

}