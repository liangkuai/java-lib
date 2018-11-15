package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liangkuai
 * @date 2018/11/13
 */
public class MyLockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            System.out.println("thread start");
            LockSupport.park();
            System.out.println("thread end");
        });
        t.start();
        LockSupport.unpark(t);

        TimeUnit.SECONDS.sleep(3);
//        LockSupport.unpark(t);
        System.out.println("main end");
    }
}