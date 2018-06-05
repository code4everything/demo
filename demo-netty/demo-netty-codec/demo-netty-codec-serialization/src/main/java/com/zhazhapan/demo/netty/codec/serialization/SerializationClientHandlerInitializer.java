package com.zhazhapan.demo.netty.codec.serialization;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class SerializationClientHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ObjectDecoder(NettyConsts.MAX_OBJECT_SIZE, ClassResolvers.weakCachingConcurrentResolver
                (this.getClass().getClassLoader())));
        pipeline.addLast(new ObjectEncoder());
        pipeline.addLast(new SerializationClientHandler());
    }
}
