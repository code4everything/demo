package org.code4everything.demo.sofarpc;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class ZookeeperNodesSeer {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("47.110.247.176:2181");
        printNodes(zkClient, "/");
    }

    private static void printNodes(ZkClient zkClient, String path) {
        List<String> children = zkClient.getChildren(path);
        if (CollUtil.isEmpty(children)) {
            Console.log(path);
        } else {
            children.forEach(child -> printNodes(zkClient, StrUtil.addSuffixIfNot(path, "/") + child));
        }
    }
}
