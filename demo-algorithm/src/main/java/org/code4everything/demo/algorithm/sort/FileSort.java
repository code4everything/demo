package org.code4everything.demo.algorithm.sort;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/3/13
 **/
public class FileSort {

    private static final String PATH = "E:\\temp\\bigData.txt";

    private static final int MIN = 1000_0000;

    private static final int MAX = 1_0000_0000;

    public static void main(String[] args) throws IOException {
        FileSort fileSort = new FileSort();
        fileSort.bitSort();
    }

    private void bitSort() throws IOException {
        long start = System.currentTimeMillis();
        short[] vals = new short[MAX - MIN];
        File file = new File(PATH);
        generateBigFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while (StrUtil.isNotEmpty(str = reader.readLine())) {
                vals[Integer.parseInt(str) - MIN]++;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < vals.length; i++) {
                int val = i + MIN;
                for (int j = 0; j < vals[i]; j++) {
                    writer.write(val + "\r\n");
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 一亿个数字，用int[]数组读出来需要380多MB
     */
    private void generateBigFile() throws IOException {
        final int len = 1_0000_0000;
        File file = new File(PATH);
        if (file.exists()) {file.delete();}
        if (file.createNewFile()) {
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                data.add(RandomUtil.randomInt(MIN, MAX));
            }
            FileUtil.writeUtf8Lines(data, file);
        }
    }
}
