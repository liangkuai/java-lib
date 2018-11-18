package myspring;

import myspring.bean.BeanDefinition;
import myspring.bean.factory.AutowireCapableBeanFactory;
import myspring.bean.factory.BeanFactory;
import org.junit.Test;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class BeanFactoryTest {

    @Test
    public void Test() {

        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注入 bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("myspring.HelloService");
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 3.获取 bean
        HelloService helloWorldService = (HelloService) beanFactory.getBean("helloService");
        helloWorldService.hello();
    }
}