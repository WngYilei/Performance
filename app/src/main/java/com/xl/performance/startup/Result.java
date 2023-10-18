package com.xl.performance.startup;/**
 * @Author : wangyilei
 * @Date : 2023/10/17
 * Desc :  任务返回的结果
 */

public class Result<T> {

    public T data;

    public Result(T data) {
        this.data = data;
    }
}

