package com.zhazhapan.demo.netty.codec.jackson;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import com.zhazhapan.modules.constant.ValueConsts;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new JacksonClientHandlerInitializer());
            Channel channel = bootstrap.connect(NettyConsts.LOCAL_HOST, NettyConsts.JACKSON_PORT).sync().channel();
            JacksonBean user = new JacksonBean();
            user.setAge(27);
            user.setName("孙悟空");
            List<String> sons = new ArrayList<String>();
            for (int i = 0; i < ValueConsts.THREE_INT; i++) {
                sons.add("Lucy" + i);
                sons.add("Lily" + i);
            }
            user.setSons(sons);
            Map<String, String> addresses = new HashMap<String, String>(4);
            for (int i = 0; i < ValueConsts.THREE_INT; i++) {
                addresses.put("001" + i, "18998366112");
                addresses.put("002" + i, "15014965012");
            }
            user.setAddresses(addresses);
            channel.writeAndFlush(user);
            channel.closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
