package org.code4everything.demo.mybatis.dp;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 无实现类的代理
        ProxyMapper mapper = (ProxyMapper) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[]{ProxyMapper.class}, (proxy, method, args1) -> {
            System.out.println(proxy.getClass().getName());
            Select select = method.getAnnotation(Select.class);
            if (select != null) {
                System.out.println(Arrays.toString(select.value()));
            }
            return null;
        });
        mapper.selectProxy();

        // 有实现类的代理
        mapper = (ProxyMapper) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[]{ProxyMapper.class}, new DynamicProxyHandler<ProxyMapper>(new ProxyMapperImpl()));
        mapper.selectProxy();
    }
}
