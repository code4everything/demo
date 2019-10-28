package org.code4everything.demo.sofarpc;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import org.code4everything.demo.sofarpc.service.SofaService;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class Client {

    public static void main(String[] args) {
        RegistryConfig registryConfig = new RegistryConfig().setProtocol("zookeeper").setAddress("47.110.247.176:2181");
        // @formatter:off
        ConsumerConfig<SofaService> consumerConfig = new ConsumerConfig<SofaService>()
                .setInterfaceId(SofaService.class.getName())
                .setProtocol("bolt")
                .setLoadBalancer("roundRobin")
                .setRetries(2)
                //.setDirectUrl("bolt://127.0.0.1:12221");
                .setRegistry(Consts.REGISTRY_CONFIG);
        // @formatter:on

        SofaService sofaService = consumerConfig.refer();
        while (true) {
            Console.log(sofaService.sayHello("world"));
            ThreadUtil.sleep(1000);
        }
    }
}
