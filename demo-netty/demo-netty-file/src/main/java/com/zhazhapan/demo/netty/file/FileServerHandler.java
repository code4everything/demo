package com.zhazhapan.demo.netty.file;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        File file = new File(msg);
        if (file.exists()) {
            if (!file.isFile()) {
                ctx.writeAndFlush("Not a file : " + file + NettyConsts.LINE_SEPARATOR);
                return;
            }
            ctx.write(file + " " + file.length() + NettyConsts.LINE_SEPARATOR);
            RandomAccessFile randomAccessFile = new RandomAccessFile(msg, "r");
            FileRegion region = new DefaultFileRegion(
                    randomAccessFile.getChannel(), 0, randomAccessFile.length());
            ctx.write(region);
            ctx.writeAndFlush(NettyConsts.LINE_SEPARATOR);
            randomAccessFile.close();
        } else {
            ctx.writeAndFlush("File not found: " + file + NettyConsts.LINE_SEPARATOR);
        }
    }
}
