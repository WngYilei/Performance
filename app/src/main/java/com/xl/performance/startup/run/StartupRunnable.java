package com.xl.performance.startup.run;

import android.content.Context;
import android.os.Process;

import com.xl.performance.startup.Result;
import com.xl.performance.startup.Startup;
import com.xl.performance.startup.manager.StartupCacheManager;
import com.xl.performance.startup.manager.StartupManager;

/**
 * @Author : wangyilei
 * @Date : 2023/10/18
 * Desc :
 */
public class StartupRunnable implements Runnable {
    private StartupManager startupManager;
    private Startup<?> startup;
    private Context context;

    public StartupRunnable(Context context, Startup<?> startup,
                           StartupManager startupManager) {
        this.context = context;
        this.startup = startup;
        this.startupManager = startupManager;
    }

    @Override
    public void run() {
        Process.setThreadPriority(startup.getThreadPriority());
        startup.toWait();
        Object result = startup.createTask(context);
        StartupCacheManager.getInstance().saveInitializedComponent(startup.getClass(),
                new Result(result));

        startupManager.notifyChildren(startup);

    }
}
