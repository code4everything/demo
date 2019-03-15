package com.zhazhapan.demo.algorithm.sort;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/3/13
 **/
public class FileSort {

    public static void main(String[] args) throws IOException {
        FileSort fileSort = new FileSort();
        fileSort.generateBigFile();
    }

    private void generateBigFile() throws IOException {
        File file = new File("E:\\temp\\bigData.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            data.add(RandomUtil.randomInt(10000000, 100000000));
        }
        FileUtil.writeUtf8Lines(data, file);
    }
}
