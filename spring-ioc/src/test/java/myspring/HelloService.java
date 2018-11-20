package myspring;

/**
 * @author liangkuai
 * @date 2018/11/18
 */
public class HelloService {

    private String text;
    private OutputService outputService;


    public void hello(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
