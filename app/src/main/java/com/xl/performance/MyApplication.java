package com.xl.performance;

import android.app.Application;

import com.xl.performance.startup.manager.StartupManager;
import com.xl.performance.task.JavaTask;
import com.xl.performance.task.SocketTask;
import com.xl.performance.task.DesignTask;
import com.xl.performance.task.HttpTask;
import com.xl.performance.task.OkhttpTask;


/**
 * @Author : wyl
 * @Date : 2023/10/15
 * Desc :
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        TimerUtils.start();

          /*1314*/
//        new JavaTask().createTask(this);
//        new SocketTask().createTask(this);
//        new DesignTask().createTask(this);
//        new HttpTask().createTask(this);
//        new OkhttpTask().createTask(this);

          /*905*/
        new StartupManager.Builder()
                .addStartup(new OkhttpTask())
                .addStartup(new HttpTask())
                .addStartup(new DesignTask())
                .addStartup(new SocketTask())
                .addStartup(new JavaTask())
                .build(this)
                .start().await();


        TimerUtils.end();
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
