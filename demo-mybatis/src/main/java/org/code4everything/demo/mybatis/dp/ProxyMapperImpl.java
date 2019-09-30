package org.code4everything.demo.mybatis.dp;

import java.util.concurrent.TimeUnit;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class ProxyMapperImpl implements ProxyMapper {

    @Override
    public void selectProxy() {
        System.out.println();
        System.out.println("enter method");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("exit method");
    }
}
