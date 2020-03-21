package myspring.beans.factory;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
