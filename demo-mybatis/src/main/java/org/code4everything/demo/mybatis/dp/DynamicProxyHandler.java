package org.code4everything.demo.mybatis.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class DynamicProxyHandler<T> implements InvocationHandler {

    private T target;

    public DynamicProxyHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException,
            IllegalAccessException {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        System.out.println("run time: " + (System.currentTimeMillis() - start));
        return obj;
    }
}
