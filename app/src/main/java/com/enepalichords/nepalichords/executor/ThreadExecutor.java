package com.enepalichords.nepalichords.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;


/**
 * Created by sameer on 3/8/15.
 */
public class ThreadExecutor implements Executor {

    private static final int POOL_SIZE = 3;
    private static final int MAX_POOL = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORKING_QUEUE = new LinkedBlockingQueue<Runnable>();
    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public ThreadExecutor() {
        int corePoolSize = POOL_SIZE;
        int maxPoolSize = MAX_POOL;
        int keepAliveTime = KEEP_ALIVE_TIME;
        TimeUnit timeUnit = TIME_UNIT;
        BlockingQueue<Runnable> workingQueue = WORKING_QUEUE;
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workingQueue);
    }

    @Override
    public void run(final Interactor interactor) {
        if (interactor != null)
        {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    interactor.run();
                }
            });
        }
    }
}
