package org.code4everything.demo.springboot.thrift.client.web;

import org.code4everything.demo.springboot.thrift.client.thrift.ThriftClient;
import org.code4everything.demo.springboot.thrift.common.ThriftRequest;
import org.code4everything.demo.springboot.thrift.common.ThriftResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2019/10/16
 */
@Slf4j
@RestController
@RequestMapping("/thrift")
public class ThriftController {

    private final ThriftClient thriftClient;

    public ThriftController(ThriftClient thriftClient) {this.thriftClient = thriftClient;}

    @GetMapping("/request")
    public ThriftResponse requestThriftServer(String msg) {
        try {
            // RPC调用
            thriftClient.open();
            return thriftClient.getThriftService().doRequest(new ThriftRequest(msg));
        } catch (Exception e) {
            log.error("Thrift调用失败！", e);
            return null;
        } finally {
            thriftClient.close();
        }
    }
}
