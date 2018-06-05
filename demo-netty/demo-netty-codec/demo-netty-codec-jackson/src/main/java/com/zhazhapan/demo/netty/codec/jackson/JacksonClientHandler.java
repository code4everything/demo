package com.zhazhapan.demo.netty.codec.jackson;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonClientHandler extends SimpleChannelInboundHandler<JacksonBean> {

    private final Logger logger = Logger.getLogger(JacksonClientHandler.class);

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, JacksonBean jacksonBean) throws
            Exception {
        logger.info("client get message from server: " + JacksonMapper.getInstance().writeValueAsString(jacksonBean));
    }
}
