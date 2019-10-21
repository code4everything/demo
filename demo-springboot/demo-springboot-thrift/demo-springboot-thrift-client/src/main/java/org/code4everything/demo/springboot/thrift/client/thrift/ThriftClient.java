package org.code4everything.demo.springboot.thrift.client.thrift;

import org.code4everything.demo.springboot.thrift.client.config.ThriftProperties;
import org.code4everything.demo.springboot.thrift.common.ThriftService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Thrift客户端
 *
 * @author pantao
 * @since 2019/10/16
 */
@Component
public class ThriftClient {

    private final ThriftProperties properties;

    private ThriftService.Client client;

    private TSocket transport;

    public ThriftClient(ThriftProperties properties) {this.properties = properties;}

    @PostConstruct
    public void start() {
        // 创建一个从网络中读取数据的传输层对象
        transport = new TSocket(properties.getHost(), properties.getPort());
        // 传输协议（负责数据的编解码）
        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        // 创建Thrift客户端
        client = new ThriftService.Client(protocol);
    }

    public ThriftService.Client getThriftService() {
        return client;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }
}
