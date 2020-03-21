/**
 * thread pool 拒绝策略接口
 *
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyRejectedExecutionHandler {

    void rejectedExecution(Runnable r, MyThreadPoolExecutor e);
}
