package org.code4everything.demo.guava.reflect;

import com.google.common.reflect.Reflection;
import org.code4everything.boot.base.function.VoidFunction;

/**
 * @author pantao
 * @since 2019/10/4
 */
@SuppressWarnings("UnstableApiUsage")
public class DynamicProxyDemo {

    public static void main(String[] args) {
        VoidFunction function = Reflection.newProxy(VoidFunction.class, (proxy, method, args1) -> {
            System.out.println("dynamic proxy");
            return null;
        });
        function.call();
    }
}
