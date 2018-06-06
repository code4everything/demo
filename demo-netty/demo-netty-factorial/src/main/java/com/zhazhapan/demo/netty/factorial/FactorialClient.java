package com.zhazhapan.demo.netty.factorial;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.SSLException;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class FactorialClient {

    public static void main(String[] args) throws InterruptedException, SSLException {
        final SslContext sslCtx;
        if (NettyConsts.ENABLE_SSL) {
            sslCtx = SslContext.newClientContext(InsecureTrustManagerFactory.INSTANCE);
        } else {
            sslCtx = null;
        }

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new FactorialClientInitializer(sslCtx));
            // Make a new connection.
            ChannelFuture f = b.connect(NettyConsts.LOCAL_HOST, NettyConsts.FACTORIAL_PORT).sync();
            // Get the handler instance to retrieve the answer.
            FactorialClientHandler handler = (FactorialClientHandler) f.channel().pipeline().last();
            // Print out the answer.
            System.err.format("Factorial of %,d is: %,d", NettyConsts.FACTORIAL_COUNT, handler.getFactorial());
        } finally {
            group.shutdownGracefully();
        }
    }
}
