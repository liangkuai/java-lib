package structural.adapter.object;

import structural.adapter.object.target.TwoPlug;

/**
 * 电源插座
 *
 * @author liukai
 * @date 2020-04-04
 */
public class PowerSocket {

    /**
     * 用两脚插头进行充电
     */
    void charge(TwoPlug plug) {
        plug.getTwoPlug();
        System.out.println("进行充电...");
    }
}
