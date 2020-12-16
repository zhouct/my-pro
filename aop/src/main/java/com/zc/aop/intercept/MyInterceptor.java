package com.zc.aop.intercept;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("拦截方法执行前:" + invocation.getMethod().getName());
        Object obj = invocation.proceed();
        System.out.println("拦截方法执行后:" + invocation.getMethod().getName());
        return obj;
    }
}
