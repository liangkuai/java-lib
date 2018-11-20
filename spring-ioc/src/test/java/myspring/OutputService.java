package myspring;

import org.junit.Assert;

/**
 * @author liangkuai
 * @date 2018/11/20
 */
public class OutputService {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public void output(String text) {
        Assert.assertNotNull(helloService);
        System.out.println(text);
    }
}
