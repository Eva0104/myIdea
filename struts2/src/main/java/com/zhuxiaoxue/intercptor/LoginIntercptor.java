package com.zhuxiaoxue.intercptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class LoginIntercptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionProxy actionProxy = invocation.getProxy();

        String namespace = actionProxy.getNamespace();
        String actionName = actionProxy.getActionName();

        if("/".equals(namespace) && ("index".equals(actionName) || "login".equals(actionName)) ){
            return actionProxy.execute();
        }else {
            Map<String,Object> session = ActionContext.getContext().getSession();

            String sessionValue = (String) session.get("curr_user");
            if(session != null){
                return actionProxy.execute();
            }else {
                return Action.LOGIN;
            }
        }
    }
}
