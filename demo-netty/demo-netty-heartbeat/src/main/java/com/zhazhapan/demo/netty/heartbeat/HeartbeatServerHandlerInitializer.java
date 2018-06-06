package com.zhazhapan.demo.netty.heartbeat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class HeartbeatServerHandlerInitializer extends ChannelInitializer<Channel> {

    private static final int READ_IDLE_TIME_OUT = 4;

    private static final int WRITE_IDLE_TIME_OUT = 5;

    private static final int ALL_IDLE_TIME_OUT = 7;

    @Override
    protected void initChannel(Channel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(READ_IDLE_TIME_OUT,
                WRITE_IDLE_TIME_OUT, ALL_IDLE_TIME_OUT, TimeUnit.SECONDS));
        pipeline.addLast(new HeartbeatServerHandler());
    }
}
