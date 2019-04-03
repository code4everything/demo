package com.zhazhapan.demo.algorithm.leetcode.hash;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/2/25
 **/
@LeetCode(id = 706, difficulty = Difficulty.EASY, title = "设计哈希映射")
public class MyHashMap {

    private int[] values = new int[1000001];

    private boolean[] has = new boolean[1000001];

    public MyHashMap() { }

    public void put(int key, int value) {
        values[key] = value;
        has[key] = true;
    }

    public int get(int key) {
        return has[key] ? values[key] : -1;
    }

    public void remove(int key) {
        has[key] = false;
    }
}
