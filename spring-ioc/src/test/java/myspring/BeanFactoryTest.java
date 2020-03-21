package myspring;

import myspring.beans.BeanDefinition;
import myspring.beans.factory.AbstractBeanFactory;
import myspring.beans.factory.AutowireCapableBeanFactory;
import myspring.beans.factory.XmlBeanDefinitionReader;
import myspring.beans.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class BeanFactoryTest {

    @Test
    public void Test() throws Exception {
        // 1. 读取 bean 配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");


        // 2. 初始化 BeanFactory，注册 bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3. 获取 bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }
}