package com.zhuxiaoxue.intercptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimerIntercptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionProxy actionProxy = invocation.getProxy();
        String namespace = actionProxy.getNamespace();
        String methodName = actionProxy.getMethod();
        String name = actionProxy.getActionName();


        Long startTime = System.currentTimeMillis();
        String result = actionProxy.execute();
        Long endTime = System.currentTimeMillis();

        System.out.println(namespace + "/" + name + ",方法：" + methodName + "耗費：" + (endTime - startTime) + "ms");
        return result;
    }
}
