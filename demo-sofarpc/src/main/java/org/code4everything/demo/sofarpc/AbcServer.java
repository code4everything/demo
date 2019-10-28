package org.code4everything.demo.sofarpc;

import com.alipay.sofa.rpc.common.RpcConfigs;
import com.alipay.sofa.rpc.common.RpcOptions;
import com.alipay.sofa.rpc.config.ConfigUniqueNameGenerator;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.alipay.sofa.rpc.config.UserThreadPoolManager;
import com.alipay.sofa.rpc.server.UserThreadPool;
import org.code4everything.demo.sofarpc.service.SofaService;
import org.code4everything.demo.sofarpc.service.impl.SofaServiceImpl;

/**
 * @author pantao
 * @since 2019/10/23
 */
public class AbcServer {

    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig().setProtocol("bolt").setPort(12200).setDaemon(false);

        // @formatter:off
        ProviderConfig<SofaService> providerConfig = new ProviderConfig<SofaService>()
                .setInterfaceId(SofaService.class.getName())
                .setRef(new SofaServiceImpl())
                .setServer(serverConfig);

        // @formatter:on

        // 关闭链路追踪
        RpcConfigs.putValue(RpcOptions.DEFAULT_TRACER, "");
        // 自定义线程池，并暴露服务
        UserThreadPool threadPool = new UserThreadPool();
        UserThreadPoolManager.registerUserThread(ConfigUniqueNameGenerator.getUniqueName(providerConfig), threadPool);
        providerConfig.export();
    }
}
