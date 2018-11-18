package myspring;

import myspring.bean.BeanDefinition;
import myspring.bean.PropertyValue;
import myspring.bean.PropertyValues;
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

        // 2.创建 BeanDefinition 实例存储 bean 信息
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("myspring.HelloService");

        // 3.设置 bean 的属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello world"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.将 BeanDefinition 注册到 BeanFactory
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 5.获取 bean
        HelloService helloWorldService = (HelloService) beanFactory.getBean("helloService");
        helloWorldService.hello();
    }
}