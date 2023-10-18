package com.xl.performance.startup;

import android.content.Context;

import java.util.List;

/**
 * @Author : wangyilei
 * @Date : 2023/10/17
 * Desc :  任务
 */
public interface Startup<T> extends Dispatcher {

    /**
     * 创建任务
     * @return
     */
     T createTask(Context context);


    /**
     * 依赖任务
     * @return
     */
     List<Class<? extends Startup<?>>>  dependencies();


    /**
     * 依赖数量
     * @return
     */
     int  getDependenciesCount();

}
