package com.zhazhapan.demo.netty.codec.jackson;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonServerHandler extends SimpleChannelInboundHandler<JacksonBean> {

    private final Logger logger = Logger.getLogger(JacksonServerHandler.class);

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, JacksonBean msg) throws Exception {
        ctx.writeAndFlush(msg);
        logger.info("get message from client: " + JacksonMapper.getInstance().writeValueAsString(msg));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel inbound = ctx.channel();
        logger.error("client[" + inbound.remoteAddress() + "] error: " + cause.getMessage());
        ctx.close();
    }
}
