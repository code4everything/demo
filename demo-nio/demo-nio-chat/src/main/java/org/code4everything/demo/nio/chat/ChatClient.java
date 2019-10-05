package org.code4everything.demo.nio.chat;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Charsets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/10/4
 */
public class ChatClient {

    public static void main(String[] args) throws IOException {
        ChatClient client = new ChatClient();
        client.start();
    }

    void start() throws IOException {
        // 连接服务器
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7000));

        // 接收服务器端的响应数据
        // 新开线程，专门负责来接收服务器端的响应数据
        // selector, socketChannel
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        ThreadUtil.execute(() -> {
            try {
                while (true) {
                    int readyChannels = selector.select();
                    if (readyChannels == 0) {continue;}
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if (selectionKey.isReadable()) {
                            readHandler(selector, selectionKey);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 向服务器发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (StrUtil.isEmpty(string)) {
                continue;
            }
            channel.write(Charsets.UTF_8.encode(string));
        }
    }

    private void readHandler(Selector selector, SelectionKey selectionKey) throws IOException {
        String received = NioUtil.readFrom(selector, selectionKey);
        if (StrUtil.isNotEmpty(received)) {
            System.out.println("received: " + received);
        }
    }
}
