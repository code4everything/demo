package com.zhazhapan.demo.algorithm.sort;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * @author pantao
 * @since 2019/3/13
 **/
class SortTest {

    private int[] data = new int[10000];

    public static void main(String[] args) {
        SortTest test = new SortTest();

        test.resetData();
        test.ordinarySort();

        test.resetData();
        test.bubbleSort();

        test.resetData();
        test.insertSort();

        test.resetData();
        test.quickSort();

        test.resetData();
    }

    /**
     * 快速排序
     */
    private void quickSort() {
        long start = System.currentTimeMillis();
        quickSortHelper(data, 0, data.length - 1);
        Console.log("quick sort used times: " + duration(start));
    }

    private void quickSortHelper(int[] data, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int base = data[i];
            while (i < j) {
                while (j > i && data[j] >= base) {
                    j--;
                }
                while (j > i && data[i] <= base) {
                    i++;
                }
                if (i < j) {
                    ArrayUtil.swap(data, i, j);
                } else if (i == j) {
                    ArrayUtil.swap(data, start, i);
                }
            }
            quickSortHelper(data, start, j - 1);
            quickSortHelper(data, i + 1, end);
        }
    }

    /**
     * 插入排序
     */
    private void insertSort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < data.length; i++) {
            int curr = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > curr) {
                data[j + 1] = data[j--];
            }
            data[j + 1] = curr;
        }
        Console.log("insert sort used times: " + duration(start));
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    ArrayUtil.swap(data, j, j + 1);
                }
            }
        }
        Console.log("bubble sort used times: " + duration(start));
    }

    /**
     * 普通排序
     */
    private void ordinarySort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    ArrayUtil.swap(data, i, j);
                }
            }
        }
        Console.log("ordinary sort used times: " + duration(start));
    }

    private String duration(long start) {
        long diff = System.currentTimeMillis() - start;
        checkSortResult();
        return (diff / 1000) + "." + (diff % 1000) + " s";
    }

    private void resetData() {
        for (int i = 0; i < data.length; i++) {
            data[i] = RandomUtil.randomInt(data.length);
        }
    }

    private void checkSortResult() {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                throw new SortErrorException("sort error");
            }
        }
    }
}

class SortErrorException extends RuntimeException {

    SortErrorException(String msg) {
        super(msg);
    }
}
