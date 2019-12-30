package com.jumao.testplugin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicTestProxy implements InvocationHandler {

    private Object target;

    public DynamicTestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        System.out.println(proxy.getClass().getSimpleName());
        return result;
    }
}
