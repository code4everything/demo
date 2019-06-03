package com.zhazhapan.demo.test;

import java.io.File;

/**
 * @author pantao
 * @since 2019/6/3
 **/
public class FileTest {

    public static void main(String[] args) {
        deleteFile(new File("C:\\Users\\73581\\OneDrive"));
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(f);
            }
        }
        file.delete();
    }
}
