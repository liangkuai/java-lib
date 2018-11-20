package myspring.bean.factory;

import myspring.bean.BeanDefinition;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
