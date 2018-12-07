import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public interface MyExecutorService extends MyExecutor {

    Future submit(Runnable task);

    <T> Future<T> submit(Runnable task, T result);

    <T> Future<T> submit(Callable<T> task);

    boolean isShutdown();
}
