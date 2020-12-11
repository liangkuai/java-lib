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
    private Object targetObj;

    public ProxyInvocationHandler(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置代理逻辑");
        Object result = method.invoke(targetObj, args);
        System.out.println("后置代理逻辑");
        return result;
    }

}
