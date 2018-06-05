package com.zhazhapan.demo.netty.codec.serialization;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import com.zhazhapan.modules.constant.ValueConsts;
import com.zhazhapan.util.RandomUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class SerializationClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SerializationClientHandlerInitializer());

            Channel channel = bootstrap.connect(NettyConsts.LOCAL_HOST, NettyConsts.SERIALIZATION_PORT).sync()
                    .channel();
            SerializationBean user;
            for (int i = 0; i < ValueConsts.THREE_INT; i++) {
                user = new SerializationBean();
                user.setAge(i);
                user.setName(RandomUtils.getRandomStringOnlyLetter(ValueConsts.NINE_INT));
                channel.write(user);
            }
            channel.flush();
            channel.closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
