package org.code4everything.demo.sofarpc;

import com.alipay.sofa.rpc.config.RegistryConfig;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class Consts {

    public static final RegistryConfig REGISTRY_CONFIG = new RegistryConfig().setProtocol("zookeeper").setAddress(
            "192.168.0.100:2181");
}
