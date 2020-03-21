package myspring.beans.factory;

import myspring.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);

        beanDefinitionNames.add(name);

//        Object bean = doCreateBean(beanDefinition);
//        beanDefinition.setBean(bean);
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }


    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);

        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }

        return bean;
    }

    /**
     * 创建 bean 实例
     *
     * 有 BeanFactory 完成
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
