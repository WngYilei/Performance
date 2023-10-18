package com.xl.performance.startup;

import java.util.concurrent.Executor;

/**
 * @Author : wangyilei
 * @Date : 2023/10/18
 * Desc :
 */
public interface Dispatcher {

    /**
     * 是否在主线程执行
     */
    boolean callCreateOnMainThread();

    /**
     * 是否需要等待该任务执行完成
     */
    boolean waitOnMainThread();

    /**
     * 等待
     */
    void toWait();

    /**
     * 有父任务执行完毕
     * 计数器-1
     */
    void toNotify();

    Executor executor();

    int getThreadPriority();
}
