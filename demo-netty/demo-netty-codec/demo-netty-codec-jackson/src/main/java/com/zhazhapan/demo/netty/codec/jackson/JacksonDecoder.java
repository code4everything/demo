package com.zhazhapan.demo.netty.codec.jackson;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.InputStream;
import java.util.List;

/**
 * <a href="https://blog.csdn.net/gengv/article/details/5178055">在泛型中得到T.class</a>
 *
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonDecoder<T> extends ByteToMessageDecoder {

    private Class<T> clazz;

    public JacksonDecoder(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ByteBufInputStream bbis = new ByteBufInputStream(in);
        out.add(JacksonMapper.getInstance().readValue((InputStream) bbis, clazz));
    }
}
