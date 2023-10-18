package com.xl.performance.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;

import androidx.annotation.Nullable;


import com.xl.performance.LogUtils;
import com.xl.performance.startup.AndroidStartup;
import com.xl.performance.startup.Startup;

import java.util.List;

public class JavaTask extends AndroidStartup<String> {


    @Override
    public String createTask(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t+" JavaTask：学习Java基础");
        SystemClock.sleep(200);
        LogUtils.log(t+" JavaTask：掌握Java基础");
        return "JavaTask返回数据";
    }



    //执行此任务需要依赖哪些任务
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return super.dependencies();
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
