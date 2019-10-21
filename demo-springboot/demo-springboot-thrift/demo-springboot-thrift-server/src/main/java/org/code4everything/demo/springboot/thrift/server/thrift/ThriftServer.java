package org.code4everything.demo.springboot.thrift.server.thrift;

import cn.hutool.core.thread.ThreadUtil;
import org.code4everything.demo.springboot.thrift.common.ThriftService;
import org.code4everything.demo.springboot.thrift.server.config.ThriftProperties;
import org.code4everything.demo.springboot.thrift.server.service.thrift.impl.ThriftServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Thrift服务端
 *
 * @author pantao
 * @since 2019/10/16
 */
@Slf4j
@Component
public class ThriftServer {

    private final TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

    private final TTransportFactory transportFactory = new TTransportFactory();

    private final ThriftProperties properties;

    private final ThriftServiceImpl thriftService;

    public ThriftServer(ThriftProperties properties, ThriftServiceImpl thriftService) {
        this.properties = properties;
        this.thriftService = thriftService;
    }

    @PostConstruct
    public void start() {
        ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor<>(thriftService);
        TServerTransport transport;
        try {
            transport = new TServerSocket(properties.getPort());
        } catch (TTransportException e) {
            log.error("Thrift服务启动失败！", e);
            return;
        }
        TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
        args.processor(processor);
        args.protocolFactory(protocolFactory);
        args.transportFactory(transportFactory);
        args.minWorkerThreads(properties.getMinThread());
        args.maxWorkerThreads(properties.getMaxThread());

        TServer server = new TThreadPoolServer(args);
        log.info("Thrift启动成功！");
        ThreadUtil.execute(server::serve);
    }
}
