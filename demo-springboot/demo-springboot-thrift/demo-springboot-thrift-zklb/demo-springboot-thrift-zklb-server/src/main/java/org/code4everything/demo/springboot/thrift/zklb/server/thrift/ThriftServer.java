package org.code4everything.demo.springboot.thrift.zklb.server.thrift;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.code4everything.demo.springboot.thrift.common.ThriftService;
import org.code4everything.demo.springboot.thrift.zklb.server.config.ThriftProperties;
import org.code4everything.demo.springboot.thrift.zklb.server.config.ThriftProperty;
import org.code4everything.demo.springboot.thrift.zklb.server.service.thrift.impl.ThriftServiceOneImpl;
import org.code4everything.demo.springboot.thrift.zklb.server.service.thrift.impl.ThriftServiceTwoImpl;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author pantao
 * @since 2019/10/18
 */
@Slf4j
@Configuration
public class ThriftServer {

    private final String parentNode = "/thrift";

    private final ThriftProperties thriftProperties;

    @Resource(name = "oneThrift")
    private ThriftServiceOneImpl oneThrift;

    @Resource(name = "twoThrift")
    private ThriftServiceTwoImpl twoThrift;

    public ThriftServer(ThriftProperties thriftProperties) {this.thriftProperties = thriftProperties;}

    @Bean
    public TServer serverOne() {
        ZkClient zkClient = new ZkClient("192.168.0.100:2181");

        ThriftService.Processor<ThriftServiceOneImpl> processor = new ThriftService.Processor<>(oneThrift);
        TServerTransport transport;
        ThriftProperty property = thriftProperties.getServices().get(0);
        try {
            transport = new TServerSocket(property.getPort());
        } catch (TTransportException e) {
            log.error("Thrift One服务启动失败！", e);
            return null;
        }
        TThreadPoolServer.Args args = genArgsAndRegisterZk(transport, zkClient, processor, property);
        TServer server = new TThreadPoolServer(args);
        log.info("Thrift One启动成功！");
        ThreadUtil.execute(server::serve);
        return server;
    }

    @Bean
    public TServer serverTwo() {
        ZkClient zkClient = new ZkClient("192.168.0.100:2181");

        // 启动第一个服务
        ThriftService.Processor<ThriftServiceTwoImpl> processor = new ThriftService.Processor<>(twoThrift);
        TServerTransport transport;
        ThriftProperty property = thriftProperties.getServices().get(1);
        try {
            transport = new TServerSocket(property.getPort());
        } catch (TTransportException e) {
            log.error("Thrift Two服务启动失败！", e);
            return null;
        }
        TThreadPoolServer.Args args = genArgsAndRegisterZk(transport, zkClient, processor, property);
        TServer server = new TThreadPoolServer(args);
        log.info("Thrift Two启动成功！");
        ThreadUtil.execute(server::serve);
        return server;
    }

    private TThreadPoolServer.Args genArgsAndRegisterZk(TServerTransport transport, ZkClient zkClient,
                                                        ThriftService.Processor<?> processor, ThriftProperty property) {
        TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
        args.processor(processor);
        args.protocolFactory(new TBinaryProtocol.Factory());
        args.transportFactory(new TTransportFactory());
        args.minWorkerThreads(property.getMinThread());
        args.maxWorkerThreads(property.getMaxThread());

        if (!zkClient.exists(parentNode)) {
            zkClient.createPersistent(parentNode, true);
        }
        String node = parentNode + "/" + NetUtil.getLocalhostStr() + ":" + property.getPort();
        if (!zkClient.exists(node)) {
            zkClient.createEphemeral(node, "192.168.0.100:" + property.getPort());
        }
        return args;
    }
}
