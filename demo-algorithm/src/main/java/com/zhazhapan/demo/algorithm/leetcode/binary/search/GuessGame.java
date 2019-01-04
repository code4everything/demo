package com.zhazhapan.demo.algorithm.leetcode.binary.search;

/**
 * @author pantao
 * @since 2019/1/4
 **/
public class GuessGame {

    private int real;

    protected int guess(int num) {
        return Integer.compare(real, num);
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }
}
