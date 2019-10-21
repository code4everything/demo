package org.code4everything.demo.springboot.thrift.zklb.client.web;

import cn.hutool.core.util.ObjectUtil;
import org.code4everything.demo.springboot.thrift.common.ThriftRequest;
import org.code4everything.demo.springboot.thrift.common.ThriftResponse;
import org.code4everything.demo.springboot.thrift.zklb.client.thrift.ThriftClient;
import org.code4everything.demo.springboot.thrift.zklb.client.thrift.TransClientPair;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2019/10/19
 */
@Slf4j
@RestController
@RequestMapping("/thrift")
public class ThriftController {

    private final ThriftClient thriftClient;

    public ThriftController(ThriftClient thriftClient) {this.thriftClient = thriftClient;}

    @GetMapping("/request")
    public ThriftResponse requestThriftServer(String msg) {
        TransClientPair pair = thriftClient.getClient();
        if (ObjectUtil.isNull(pair)) {
            log.error("thrift server is not started!");
        }
        try {
            pair.getTrans().open();
            return pair.getClient().doRequest(new ThriftRequest(msg));
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            pair.getTrans().close();
        }
        return null;
    }
}
