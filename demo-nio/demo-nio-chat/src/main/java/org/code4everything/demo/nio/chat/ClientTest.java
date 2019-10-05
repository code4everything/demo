package org.code4everything.demo.nio.chat;

import java.io.IOException;

/**
 * @author pantao
 * @since 2019/10/5
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {
        new ChatClient().start();
    }
}
