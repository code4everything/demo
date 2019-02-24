package com.zhazhapan.demo.test;

import java.nio.ByteBuffer;

/**
 * @author pantao
 * @since 2019-02-23
 */
public class NioTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.asReadOnlyBuffer();
    }
}
