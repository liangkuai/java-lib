package myspring;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class HelloService {

    private String text;

    public void hello(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
