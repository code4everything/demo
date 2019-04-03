package com.zhazhapan.demo.algorithm.leetcode.hash;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/2/25
 **/
@LeetCode(id = 705, difficulty = Difficulty.EASY, title = "设计哈希集合")
public class MyHashSet {

    boolean[] hs = new boolean[1000001];

    public MyHashSet() { }

    public void add(int key) {
        hs[key] = true;
    }

    public void remove(int key) {
        hs[key] = false;
    }

    public boolean contains(int key) {
        return hs[key];
    }
}
