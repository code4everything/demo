package org.code4everything.demo.springboot.thrift.zklb.server.service.thrift.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import org.code4everything.demo.springboot.thrift.common.ThriftRequest;
import org.code4everything.demo.springboot.thrift.common.ThriftResponse;
import org.code4everything.demo.springboot.thrift.common.ThriftService;
import org.springframework.stereotype.Service;

/**
 * @author pantao
 * @since 2019/10/16
 */
@Service(value = "oneThrift")
public class ThriftServiceOneImpl implements ThriftService.Iface {

    @Override
    public void test() {
        Console.log("hello thrift one");
    }

    @Override
    public ThriftResponse doRequest(ThriftRequest request) {
        ThriftResponse response = new ThriftResponse();
        response.setCode(200);
        response.setSuccessful(true);
        response.setResult(CollUtil.newArrayList("hello", "thrift", "one"));
        return response;
    }
}
