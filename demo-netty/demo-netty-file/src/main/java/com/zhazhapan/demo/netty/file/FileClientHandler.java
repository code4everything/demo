package com.zhazhapan.demo.netty.file;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class FileClientHandler extends SimpleChannelInboundHandler<String> {

    private String dest;

    /**
     * @param dest 文件生成路径
     */
    FileClientHandler(String dest) {
        this.dest = dest;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        File file = new File(dest);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(msg.getBytes());
        fos.close();
    }
}
