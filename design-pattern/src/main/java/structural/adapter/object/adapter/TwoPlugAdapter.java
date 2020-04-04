package structural.adapter.object.adapter;

import structural.adapter.object.adaptee.UsbPlug;
import structural.adapter.object.target.TwoPlug;

/**
 * 适配器
 *
 * @author liangkuai
 * @date 2018/10/7
 */
public class TwoPlugAdapter implements TwoPlug {

    private UsbPlug charger;

    public TwoPlugAdapter(UsbPlug charger) {
        this.charger = charger;
    }

    @Override
    public void getTwoPlug() {
        charger.getUsbPlug();
        System.out.println("将 USB 接口适配器转换为两脚插头");
    }
}
