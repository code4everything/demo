package com.zhazhapan.demo.netty.codec.serialization;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class SerializationClientHandler extends SimpleChannelInboundHandler<SerializationBean> {

    private final Logger logger = Logger.getLogger(SerializationClientHandler.class);

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, SerializationBean msg) throws Exception {
        logger.info("get message from server: " + msg);
    }
}
