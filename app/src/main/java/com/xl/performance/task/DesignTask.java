
package com.xl.performance.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;

import androidx.annotation.Nullable;


import com.xl.performance.LogUtils;
import com.xl.performance.startup.AndroidStartup;
import com.xl.performance.startup.Startup;

import java.util.ArrayList;
import java.util.List;

public class DesignTask extends AndroidStartup<Void> {

    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(JavaTask.class);
    }




    @Override
    public Void createTask(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t+" DesignTask：学习设计模式");
        SystemClock.sleep(500);
        LogUtils.log(t+" DesignTask：掌握设计模式");
        return null;
    }

    //    执行此任务需要依赖哪些任务
    @Nullable
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
