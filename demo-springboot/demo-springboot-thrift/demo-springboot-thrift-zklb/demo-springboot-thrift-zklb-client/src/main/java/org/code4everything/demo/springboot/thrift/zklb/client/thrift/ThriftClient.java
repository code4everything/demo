package org.code4everything.demo.springboot.thrift.zklb.client.thrift;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;
import org.code4everything.demo.springboot.thrift.common.ThriftService;
import org.I0Itec.zkclient.ZkClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/10/18
 */
@Configuration
public class ThriftClient {

    private final Set<String> existedNodes = new HashSet<>(4, 1);

    private final List<TransClientPair> clients = new ArrayList<>();

    private List<String> children;

    /**
     * 轮询计数
     */
    private int count = 0;

    @PostConstruct
    public void init() {
        ZkClient client = new ZkClient("192.168.0.100:2181");
        if (!client.exists("/thrift")) {
            client.createPersistent("/thrift", true);
        }
        children = client.getChildren("/thrift");
        Console.log(children);
        onChildrenChanged(children);
        client.subscribeChildChanges("/thrift", (parentPath, currentChilds) -> {
            children = currentChilds;
            Console.log(currentChilds);
            onChildrenChanged(children);
        });
    }

    public TransClientPair getClient() {
        if (clients.isEmpty()) {
            return null;
        }
        int idx = Math.abs(count++ % clients.size());
        return clients.get(idx);
    }

    private void onChildrenChanged(List<String> children) {
        if (CollUtil.isEmpty(children)) {
            return;
        }
        children.forEach(child -> {
            if (existedNodes.add(child)) {
                String[] address = child.split(":");
                // 创建一个从网络中读取数据的传输层对象
                TSocket transport = new TSocket(address[0], NumberUtil.parseInt(address[1]));
                // 传输协议（负责数据的编解码）
                TBinaryProtocol protocol = new TBinaryProtocol(transport);
                // 创建Thrift客户端
                clients.add(new TransClientPair(transport, new ThriftService.Client(protocol)));
            }
        });
    }
}

