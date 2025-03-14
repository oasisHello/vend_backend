package oasis.vend.framework.manager;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import oasis.vend.common.utils.Threads;
import oasis.vend.common.utils.spring.SpringUtils;

/**
 * Async Task Manager
 * 
 * @author ruoyi
 */
public class AsyncManager
{

    /**
     * Thread Pool Service(by IOC)
     */
    private final ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");

    /**
     *  singleton
     */
    private AsyncManager(){}
    private static final AsyncManager me = new AsyncManager();

    public static AsyncManager me()
    {
        return me;
    }

    /**
     * execute task
     * 
     * @param task task
     */
    public void execute(TimerTask task)
    {
        // 10ms delay
        int OPERATE_DELAY_TIME = 10;
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
