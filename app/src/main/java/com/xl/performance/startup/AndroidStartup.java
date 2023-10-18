package com.xl.performance.startup;

import android.os.Process;

import com.xl.performance.startup.manager.ExecutorManager;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @Author : wangyilei
 * @Date : 2023/10/17
 * Desc :  任务抽象
 */
public abstract class AndroidStartup<T>  implements Startup<T> {
    private CountDownLatch mWaitCountDown = new CountDownLatch(getDependenciesCount());

    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return null;
    }

    @Override
    public int getDependenciesCount() {
        List<Class<? extends Startup<?>>> dependencies = dependencies();
        return dependencies == null ? 0 : dependencies.size();
    }


    @Override
    public Executor executor() {
        return ExecutorManager.ioExecutor;
    }

    @Override
    public void toWait() {
        try {
            mWaitCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toNotify() {
        mWaitCountDown.countDown();
    }

    @Override
    public int getThreadPriority() {
        return Process.THREAD_PRIORITY_DEFAULT;
    }
}
