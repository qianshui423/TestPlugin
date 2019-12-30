package com.jumao.testplugin.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TestProxyImpl testProxy = new TestProxyImpl();
        DynamicTestProxy dynamicTestProxy = new DynamicTestProxy(testProxy);
        ITestProxy proxy = (ITestProxy) Proxy.newProxyInstance(testProxy.getClass().getClassLoader(), testProxy.getClass().getInterfaces(), dynamicTestProxy);
        proxy.print();

        TestProxyImpl2 testProxy2 = new TestProxyImpl2();
        DynamicTestProxy dynamicTestProxy2 = new DynamicTestProxy(testProxy2);
        ITestProxy2 proxy2 = (ITestProxy2) Proxy.newProxyInstance(testProxy2.getClass().getClassLoader(), testProxy2.getClass().getInterfaces(), dynamicTestProxy2);
        proxy2.print();
    }
}
