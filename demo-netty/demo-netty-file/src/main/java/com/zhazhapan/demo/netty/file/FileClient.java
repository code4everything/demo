package com.zhazhapan.demo.netty.file;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class FileClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) {
                    ch.pipeline().addLast("encoder",
                            new StringEncoder(CharsetUtil.UTF_8));
                    ch.pipeline().addLast("decoder",
                            new StringDecoder(CharsetUtil.UTF_8));
                    ch.pipeline().addLast(new FileClientHandler(NettyConsts.FILE_DESTINATION));
                }
            });

            // 启动客户端
            ChannelFuture f = b.connect(NettyConsts.LOCAL_HOST, NettyConsts.FILE_PORT).sync();
            Channel channel = f.channel();

            // 控制台输入请求的文件路径
            System.out.println("please input file path");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            channel.writeAndFlush(in.readLine() + "\r\n");
            // 等待连接关闭
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
