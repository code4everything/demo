package org.code4everything.demo.nio.chat;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Charsets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/10/4
 */
public class ChatSever {

    public static void main(String[] args) throws IOException {
        ChatSever chatSever = new ChatSever();
        chatSever.start();
    }

    private void start() throws IOException {
        // 创建Selector
        Selector selector = Selector.open();

        // 通过ServerSocketChannel创建Channel
        ServerSocketChannel channel = ServerSocketChannel.open();

        // 为Channel绑定监听端口
        channel.bind(new InetSocketAddress(7000));

        // 设置Channel为非阻塞模式
        channel.configureBlocking(false);

        // 将channel注册到selector上，监听连接事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功！");

        // 循环等待新接入的连接
        while (true) {
            // 获取可用的channel数量
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            // 获取可用的channel集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                // 拿到selectionKey实例后，将其从集合中移除
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                // 处理接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(selector, channel);
                }
                // 处理可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selector, selectionKey);
                }
            }
        }
        // 根据就绪状态，调用对应方法处理响应业务逻辑
    }

    private void acceptHandler(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        // 获取socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 将channel设置为非阻塞模式
        socketChannel.configureBlocking(false);
        // 将channel注册到selector上
        socketChannel.register(selector, SelectionKey.OP_READ);
        // 回复客户端提示消息
        socketChannel.write(Charsets.UTF_8.encode("你与聊天室里其他人都不是好友关系，请注意隐私安全！"));
    }

    private void readHandler(Selector selector, SelectionKey selectionKey) throws IOException {
        String received = NioUtil.readFrom(selector, selectionKey);
        if (StrUtil.isEmpty(received)) {
            return;
        }
        System.out.println("received: " + received);
        // 将客户端发送的消息，广播到其他客户端
        broadCast(selector, (SocketChannel) selectionKey.channel(), received);
    }

    private void broadCast(Selector selector, SocketChannel sourceChannel, String request) {
        // 获取到所有已接入的客户端channel
        Set<SelectionKey> selectionKeySet = selector.keys();
        // 循环向所有channel广播信息
        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            // 剔除发消息的客户端
            if (targetChannel instanceof SocketChannel && targetChannel != sourceChannel) {
                try {
                    // 将信息发送到targetChannel客户端
                    ((SocketChannel) targetChannel).write(Charsets.UTF_8.encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
