package org.code4everything.demo.zookeeper.web;

import cn.hutool.core.lang.Console;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/10/18
 */
@RestController
@RequestMapping("/zk")
@ConditionalOnBean(ZkServerController.class)
public class ZkClientController {

    private final ZkClient zkClient = new ZkClient("localserver:2181");

    private Set<String> listenedChildren = new HashSet<>(4, 1);

    @PostConstruct
    public void init() {
        if (!zkClient.exists("/zk")) {
            zkClient.createPersistent("/zk", true);
        }
        List<String> children = zkClient.getChildren("/zk");
        Console.log("children: " + children);

        zkClient.subscribeChildChanges("/zk", (parentPath, currentChilds) -> {
            Console.log("child changed: ");
            Console.log(currentChilds);

            // 监听节点数据变化
            currentChilds.forEach(child -> {
                if (listenedChildren.add(child)) {
                    zkClient.subscribeDataChanges("/zk/" + child, new IZkDataListener() {
                        @Override
                        public void handleDataChange(String dataPath, Object data) {
                            Console.log("[{}] data changed: {}", child, data);
                        }

                        @Override
                        public void handleDataDeleted(String dataPath) {

                        }
                    });
                }
            });
        });
    }

    @GetMapping("/list")
    public List<String> listChildren() {
        return zkClient.getChildren("/zk");
    }
}
