package proxy.dynamic_jdk;

import proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类的调用处理器
 *
 * @author liukai
 * @date 2020-12-11
 */
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理对象
    private Subject subject;

    public ProxyInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置代理逻辑");
        Object result = method.invoke(subject, args);
        System.out.println("后置代理逻辑");
        return result;
    }

}
