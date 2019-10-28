package org.code4everything.demo.sofarpc;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import org.code4everything.demo.sofarpc.service.SofaService;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class DefServer {

    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig().setProtocol("bolt").setPort(12221).setDaemon(false);

        // @formatter:off
        ProviderConfig<SofaService> providerConfig = new ProviderConfig<SofaService>()
                .setInterfaceId(SofaService.class.getName())
                .setRegistry(Consts.REGISTRY_CONFIG)
                .setServer(serverConfig)
                // @formatter:on
                .setRef(string -> "hello " + string + ", on server def");

        providerConfig.export();
    }
}
