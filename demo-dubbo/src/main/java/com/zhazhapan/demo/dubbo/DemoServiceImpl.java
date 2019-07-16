package com.zhazhapan.demo.dubbo;

/**
 * @author pantao
 * @since 2019/7/9
 **/
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
