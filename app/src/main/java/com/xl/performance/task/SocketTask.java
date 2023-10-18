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

public class SocketTask extends AndroidStartup<Void> {
    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(JavaTask.class);
    }

    @Nullable
    @Override
    public Void createTask(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t + " JavaTask：学习Socket");
        SystemClock.sleep(200);
        LogUtils.log(t + " JavaTask：掌握Socket");
        return null;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return true;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }

    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }
}
