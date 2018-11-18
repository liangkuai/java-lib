import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }
}
