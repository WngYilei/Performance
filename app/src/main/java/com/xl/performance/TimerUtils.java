package com.xl.performance;

import android.util.Log;

/**
 * @Author : wyl
 * @Date : 2023/10/15
 * Desc :
 */
public class TimerUtils {
    private static long startTime = 0l;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        long endTime = System.currentTimeMillis();

        Log.e("wangyilei", "启动耗时: " + (endTime - startTime));
    }

}
