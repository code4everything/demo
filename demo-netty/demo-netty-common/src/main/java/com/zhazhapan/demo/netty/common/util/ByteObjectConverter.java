package com.zhazhapan.demo.netty.common.util;

import java.io.*;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class ByteObjectConverter {

    public static Object ByteToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object object;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        object = ois.readObject();
        ois.close();
        bais.close();
        return object;
    }

    public static byte[] ObjectToByte(Object object) throws IOException {
        byte[] bytes;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        bytes = baos.toByteArray();
        oos.close();
        baos.close();
        return bytes;
    }
}
