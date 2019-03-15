package com.zhazhapan.demo.algorithm.sort;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2019/3/13
 **/
class SortTest {

    private int[] data = new int[10000000];

    private Queue<Pair<String, Long>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));

    public static void main(String[] args) {
        SortTest test = new SortTest();

        test.resetData();
        test.forceSort();

        test.resetData();
        test.bubbleSort();

        test.resetData();
        test.insertSort();

        test.resetData();
        test.quickSort();

        test.resetData();
        test.selectSort();

        test.resetData();
        test.shellSort();

        test.resetData();
        test.mergeSort();

        test.resetData();
        test.heapSort();

        while (!test.queue.isEmpty()) {
            Pair<String, Long> pair = test.queue.poll();
            Console.log(pair.getKey() + " sort used times: " + pair.getValue() + " ms");
        }
    }

    private void heapSort() {
        long start = System.currentTimeMillis();
        // 将待排序的序列构建成一个大顶堆
        for (int i = data.length / 2; i >= 0; i--) {
            heapSortHelper(data, i, data.length);
        }
        // 逐步将堆顶元素与末尾元素交换，并且再次调整二叉树，使其成为大顶堆
        for (int i = data.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未排序序列的最后一个记录交换
            ArrayUtil.swap(data, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapSortHelper(data, 0, i);
        }
        calculateDurationAndCheckResult(start, "heap");
    }

    /**
     * 堆化节点
     */
    private void heapSortHelper(int[] data, int i, int n) {
        int child;
        int father;
        for (father = data[i]; 2 * i + 1 < n; i = child) {
            child = 2 * i + 1;
            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && data[child] < data[child + 1]) {
                // 指向右子树
                child++;
            }
            // 如果父节点小于孩子结点，则需要交换
            if (father < data[child]) {
                data[i] = data[child];
            } else {
                // 大顶堆结构未被破坏，不需要调整
                break;
            }
        }
        data[i] = father;
    }

    /**
     * 归并排序
     */
    private void mergeSort() {
        long start = System.currentTimeMillis();
        // 组大小，从1开始，以2的倍数增长
        int groupSize;
        // 将两个组合并后的最大大小：groupSize*2
        int mergedSize = 1;
        while (mergedSize <= data.length) {
            groupSize = mergedSize;
            mergedSize <<= 1;
            // 对mergedSize大小内的两个分组进行有序合并
            for (int j = 0; j < data.length; j += mergedSize) {
                // 创建一个合法的临时工作数组
                int diff = data.length - j;
                int[] temp = new int[diff < mergedSize ? diff : mergedSize];
                // 第一个组的起始位置
                int left = j;
                // 第一个组的截止位置
                int maxLeft = j + groupSize;
                // 第二个组的起始位置
                int right = maxLeft;
                // 第二个组的截止位置
                int maxRight = j + temp.length;
                // 有序的合并两个有序分组
                for (int k = 0; k < temp.length; k++) {
                    if (right >= maxRight || (left < maxLeft && data[right] > data[left])) {
                        temp[k] = data[left++];
                    } else {
                        temp[k] = data[right++];
                    }
                }
                // 将工作数组拷贝到原数组
                System.arraycopy(temp, 0, data, j, temp.length);
            }
        }
        calculateDurationAndCheckResult(start, "merge");
    }

    /**
     * 希尔排序
     */
    private void shellSort() {
        long start = System.currentTimeMillis();
        // 按数组下标增量分组
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            // 从增量的索引位置开始进行插入排序
            for (int i = gap; i < data.length; i++) {
                int curr = data[i];
                int j = i - gap;
                // 将i处的元素插入到正确的位置
                while (j >= 0 && data[j] > curr) {
                    data[j + gap] = data[j];
                    j -= gap;
                }
                data[j + gap] = curr;
            }
        }
        calculateDurationAndCheckResult(start, "shell");
    }

    /**
     * 选择排序：数据移动次数最少
     */
    private void selectSort() {
        long start = System.currentTimeMillis();
        // 从未排序序列中找到最值并交换到序列中的最前面
        for (int i = 0; i < data.length - 1; i++) {
            // 未排序序列的起始索引
            int lowIdx = i;
            // 在当前序列中找到最小值索引
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[lowIdx]) {
                    lowIdx = j;
                }
            }
            if (lowIdx != i) {
                // 将最小值交换当前序列的最前面
                ArrayUtil.swap(data, i, lowIdx);
            }
        }
        calculateDurationAndCheckResult(start, "select");
    }

    /**
     * 快速排序
     */
    private void quickSort() {
        long start = System.currentTimeMillis();
        quickSortHelper(data, 0, data.length - 1);
        calculateDurationAndCheckResult(start, "quick");
    }

    private void quickSortHelper(int[] data, int start, int end) {
        if (start < end) {
            // 从左边开始还探测的哨兵
            int i = start;
            // 从右边开始探测的哨兵
            int j = end;
            // 基准数
            int base = data[i];
            while (i < j) {
                // 找到小于基准数的索引
                while (j > i && data[j] >= base) {
                    j--;
                }
                // 找到大于基准数的索引
                while (j > i && data[i] <= base) {
                    i++;
                }
                if (i < j) {
                    // 交换两个哨兵处的元素
                    ArrayUtil.swap(data, i, j);
                } else if (i == j) {
                    // 交换基准数与哨兵处的元素（两个哨兵一定会相遇）
                    ArrayUtil.swap(data, start, i);
                }
            }
            // 对基准数左侧的序列进行快速排序
            quickSortHelper(data, start, j - 1);
            // 对基准数右侧的序列进行快速排序
            quickSortHelper(data, i + 1, end);
        }
    }

    /**
     * 插入排序
     */
    private void insertSort() {
        long start = System.currentTimeMillis();
        // 依次对前i+1个元素进行排序
        for (int i = 1; i < data.length; i++) {
            int curr = data[i];
            int j = i - 1;
            // 将第i个元素插入到正确的位置
            while (j >= 0 && data[j] > curr) {
                data[j + 1] = data[j--];
            }
            data[j + 1] = curr;
        }
        calculateDurationAndCheckResult(start, "insert");
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort() {
        long start = System.currentTimeMillis();
        // 需要n-1趟遍历
        for (int i = 1; i < data.length; i++) {
            // 将最值依次往后挪
            for (int j = 0; j < data.length - i; j++) {
                if (data[j] > data[j + 1]) {
                    ArrayUtil.swap(data, j, j + 1);
                }
            }
        }
        calculateDurationAndCheckResult(start, "bubble");
    }

    /**
     * 排序
     */
    private void forceSort() {
        long start = System.currentTimeMillis();
        // 暴力排序
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                // 比较并进行交换
                if (data[i] > data[j]) {
                    ArrayUtil.swap(data, i, j);
                }
            }
        }
        calculateDurationAndCheckResult(start, "force");
    }

    /**
     * 格式化运行时长
     */
    private void calculateDurationAndCheckResult(long start, String sortName) {
        long diff = System.currentTimeMillis() - start;
        checkSortedResult();
        queue.offer(new Pair<>(sortName, diff));
    }

    /**
     * 重置数组
     */
    private void resetData() {
        for (int i = 0; i < data.length; i++) {
            data[i] = RandomUtil.randomInt(data.length);
        }
    }

    /**
     * 检测排序结果是否正确
     */
    private void checkSortedResult() {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                throw new SortErrorException("sort error");
            }
        }
    }

    /**
     * 自定义排序错误异常
     */
    private class SortErrorException extends RuntimeException {

        SortErrorException(String msg) {
            super(msg);
        }
    }
}
