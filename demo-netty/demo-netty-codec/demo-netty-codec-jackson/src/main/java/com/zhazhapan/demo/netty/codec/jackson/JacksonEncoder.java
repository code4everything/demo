package com.zhazhapan.demo.netty.codec.jackson;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.OutputStream;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        ByteBufOutputStream bbos = new ByteBufOutputStream(out);
        JacksonMapper.getInstance().writeValue((OutputStream) bbos, msg);
    }
}
