package locks;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyCondition {

    void awit();

    void signal();

    void signalAll();
}
