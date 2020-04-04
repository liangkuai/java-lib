package structural.adapter.object;

import structural.adapter.object.adaptee.AndroidCharger;
import structural.adapter.object.adaptee.UsbPlug;
import structural.adapter.object.adapter.TwoPlugAdapter;
import structural.adapter.object.target.TwoPlug;

/**
 * @author liangkuai
 * @date 2018/10/7
 */
public class Client {

    public static void main(String[] args) {
        PowerSocket powerSocket = new PowerSocket();

        UsbPlug charger = new AndroidCharger();
        TwoPlug adapter = new TwoPlugAdapter(charger);

        powerSocket.charge(adapter);
    }
}
