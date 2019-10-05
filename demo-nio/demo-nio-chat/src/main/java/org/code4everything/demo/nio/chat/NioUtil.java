package org.code4everything.demo.nio.chat;

import com.google.common.base.Charsets;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author pantao
 * @since 2019/10/5
 */
@UtilityClass
public class NioUtil {

    public static String readFrom(Selector selector, SelectionKey selectionKey) throws IOException {
        // 从selectionKey中获取已经就绪的channel
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 循环读取客户端请求消息
        StringBuilder builder = new StringBuilder();
        while (channel.read(buffer) > 0) {
            // 切换为读模式
            buffer.flip();
            builder.append(Charsets.UTF_8.decode(buffer));
        }
        // 将channel再次注册到selector上，监听其他可读事件
        channel.register(selector, SelectionKey.OP_READ);

        return builder.toString();
    }
}
