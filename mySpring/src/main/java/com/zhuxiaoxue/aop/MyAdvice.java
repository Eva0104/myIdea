package com.zhuxiaoxue.aop;

public class MyAdvice {

    /**
     * 前置通知
     */
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    public void afterReturingAdvice(){
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
    public void exceptionAdvice(){
        System.out.println("异常通知");
    }

    /**
     * 最终通知
     */
    public void finallyAdvice(){
        System.out.println("最终通知");
    }
}
