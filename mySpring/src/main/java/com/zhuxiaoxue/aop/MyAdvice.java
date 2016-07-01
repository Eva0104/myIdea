package com.zhuxiaoxue.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.inject.Named;


@Named
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.zhuxiaoxue.dao..*.*(..))")
    public void pointcut(){}

    /**
     * 前置通知
     */

    //@Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    //@AfterReturning(pointcut = "pointcut()",returning = "result")
    public void afterReturingAdvice(Object result) {
        System.out.println("后置通知" + result);
    }

    /**
     * 异常通知
     */

    //@AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void exceptionAdvice(Exception e) {
        System.out.println("异常通知" + e);
    }

    /**
     * 最终通知
     */
   // @After("pointcut()")
    public void finallyAdvice() {
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     */

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            System.out.println("前置通知");
            obj = joinPoint.proceed();
            System.out.println("后置通知" + obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知" + throwable.getMessage());
        }finally {
            System.out.println("最终通知");
        }
        return obj;
    }

}
