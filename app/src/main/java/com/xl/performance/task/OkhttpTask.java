package com.xl.performance.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;

import com.xl.performance.LogUtils;
import com.xl.performance.startup.AndroidStartup;
import com.xl.performance.startup.Startup;

import java.util.ArrayList;
import java.util.List;

public class OkhttpTask extends AndroidStartup<Void> {

    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(DesignTask.class);
        depends.add(HttpTask.class);
    }

    @Override
    public Void createTask(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t + " OkhttpTask：学习OkHttp");
        SystemClock.sleep(100);
        LogUtils.log(t + " OkhttpTask：掌握OkHttp");
        return null;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return false;
    }

    @Override
    public boolean waitOnMainThread() {
        return true;
    }

    //执行此任务需要依赖哪些任务
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }

}
