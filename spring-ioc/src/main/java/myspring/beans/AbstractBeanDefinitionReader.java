package myspring.beans;

import myspring.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangkuai
 * @date 2018/11/20
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
