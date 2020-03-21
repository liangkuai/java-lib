import java.util.concurrent.*;

/**
 * @author liangkuai
 * @date 2018/12/7
 */
public class MyThreadPoolExecutor extends MyAbstractExecutorService {


    /**
     * 核心线程数
     */
    private volatile int corePoolSize;

    /**
     * 最大线程数
     */
    private volatile int maximumPoolSize;


    private volatile long keepAliveTime;


    private final BlockingQueue<Runnable> workQueue;


    private volatile ThreadFactory threadFactory;


    /**
     * 拒绝策略
     *
     * 1. thread pool 关闭
     * 2. 线程数达到最大且队列已满
     */
    private volatile MyRejectedExecutionHandler handler;


    /**
     * thread pool 默认拒绝策略
     */
    private static final MyRejectedExecutionHandler defaultHandler =
            new MyThreadPoolExecutor.AbortPolicy();




    public MyThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory(), defaultHandler);
    }


    public MyThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                threadFactory, defaultHandler);
    }



    public MyThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              MyRejectedExecutionHandler handler) {
        if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }








    /**
     * 拒绝策略
     *
     * 直接抛出异常（默认）
     */
    public static class AbortPolicy implements MyRejectedExecutionHandler {

        public AbortPolicy() { }

        public void rejectedExecution(Runnable r, MyThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        }
    }

    /**
     * 拒绝策略
     *
     * 用调用者所在的线程来执行任务
     */
    public static class CallerRunsPolicy implements MyRejectedExecutionHandler {

        public CallerRunsPolicy() { }

        public void rejectedExecution(Runnable r, MyThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                r.run();
            }
        }
    }

    /**
     * 拒绝策略
     *
     * 丢弃阻塞队列中靠最前的任务，并执行当前任务
     */
    public static class DiscardOldestPolicy implements MyRejectedExecutionHandler {

        public DiscardOldestPolicy() { }

        public void rejectedExecution(Runnable r, MyThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                e.getQueue().poll();
                e.execute(r);
            }
        }
    }

    /**
     * 拒绝策略
     *
     * 直接丢弃任务
     */
    public static class DiscardPolicy implements MyRejectedExecutionHandler {

        public DiscardPolicy() { }

        public void rejectedExecution(Runnable r, MyThreadPoolExecutor e) {
        }
    }
}
