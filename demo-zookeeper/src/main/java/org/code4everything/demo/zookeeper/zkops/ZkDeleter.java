package org.code4everything.demo.zookeeper.zkops;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author pantao
 * @since 2019/10/18
 */
public class ZkDeleter {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("localserver:2181");
        zkClient.deleteRecursive("/zk");
    }
}
