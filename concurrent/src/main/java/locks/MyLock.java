package locks;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyLock {

    void lock();

    boolean tryLock();

    void unlock();
}
