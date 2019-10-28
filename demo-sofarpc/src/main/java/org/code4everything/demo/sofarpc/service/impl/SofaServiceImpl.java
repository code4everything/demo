package org.code4everything.demo.sofarpc.service.impl;

import cn.hutool.core.lang.Console;
import org.code4everything.demo.sofarpc.service.SofaService;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class SofaServiceImpl implements SofaService {

    @Override
    public String sayHello(String string) {
        string = "hello " + string;
        Console.log(string);
        return string;
    }
}
