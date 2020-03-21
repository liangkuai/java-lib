import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public class MyExecutors {

    /**
     * FixedThreadPool，可重用固定线程数的线程池。
     */
    public static MyExecutorService newFixedThreadPool(int nThreads) {
        return new MyThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    public static MyExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new MyThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory);
    }


    /**
     * CachedThreadPool，根据需要创建新线程的线程池。
     */
    public static MyExecutorService newCachedThreadPool() {
        return new MyThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    public static MyExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new MyThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                threadFactory);
    }
}
