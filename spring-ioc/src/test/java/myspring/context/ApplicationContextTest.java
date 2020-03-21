package myspring.context;

import myspring.HelloService;
import org.junit.Test;

/**
 * @author liangkuai
 * @date 2018/11/20
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        HelloService helloWorldService = (HelloService) applicationContext.getBean("helloService");
        helloWorldService.hello();
    }
}