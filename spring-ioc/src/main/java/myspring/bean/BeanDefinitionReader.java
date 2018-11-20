package myspring.bean;

/**
 * @author liangkuai
 * @date 2018/11/20
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
