package com.xl.performance.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;


import com.xl.performance.LogUtils;
import com.xl.performance.startup.AndroidStartup;
import com.xl.performance.startup.Startup;

import java.util.ArrayList;
import java.util.List;

public class HttpTask extends AndroidStartup<Void> {

    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(SocketTask.class);
    }




    @Override
    public Void createTask(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t + " HttpTask：学习Http");
        SystemClock.sleep(300);
        LogUtils.log(t + " HttpTask：掌握Http");
        return null;
    }

    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return false;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }
}
