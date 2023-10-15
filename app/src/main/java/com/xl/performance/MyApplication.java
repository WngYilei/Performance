package com.xl.performance;

import android.app.Application;
import android.content.Context;

/**
 * @Author : wyl
 * @Date : 2023/10/15
 * Desc :
 */
public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        TimerUtils.start();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test1();
        test2();
    }

    public void test1(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
