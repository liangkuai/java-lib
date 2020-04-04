package structural.adapter.object.adaptee;

/**
 * @author liukai
 * @date 2020-04-04
 */
public class AndroidCharger implements UsbPlug {

    @Override
    public void getUsbPlug() {
        System.out.println("获取 USB 插头");
    }
}
