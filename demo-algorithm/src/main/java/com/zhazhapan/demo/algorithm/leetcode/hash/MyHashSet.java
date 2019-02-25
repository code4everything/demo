package com.zhazhapan.demo.algorithm.leetcode.hash;

/**
 * @author pantao
 * @since 2019/2/25
 **/
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
