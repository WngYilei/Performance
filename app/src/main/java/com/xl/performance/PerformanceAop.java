package com.xl.performance;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author : wyl
 * @Date : 2023/10/15
 * Desc :
 */
@Aspect
public class PerformanceAop {
    @Around("call(* com.xl.performance.MyApplication.**(..))")
    public void getTime(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature = proceedingJoinPoint.getSignature();
        long time = System.currentTimeMillis();
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
         e.printStackTrace();
        }

        long cost = System.currentTimeMillis() - time;
        Log.e("wangyilei","方法："+ signature.toShortString() +     "      耗时: " + cost);
    }
}
