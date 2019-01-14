package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import org.junit.Test;

import java.util.Arrays;

public class SearcherTest {

    private Searcher searcher = new Searcher();

    @Test
    public void search() {
        assert 4 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assert -1 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }

    @Test
    public void mySqrt() {
        assert 0 == searcher.mySqrt(0);
        assert 1 == searcher.mySqrt(1);
        assert 1 == searcher.mySqrt(2);
        assert 2 == searcher.mySqrt(4);
        assert 4 == searcher.mySqrt(16);
        assert 4 == searcher.mySqrt(24);
        assert 6 == searcher.mySqrt(36);
        assert searcher.mySqrt(2147395599) == 46339;
    }

    @Test
    public void searchRange() {
        System.out.println(Arrays.toString(searcher.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searcher.searchRange(new int[]{2, 2, 2, 2}, 2)));
        System.out.println(Arrays.toString(searcher.searchRange(new int[]{2, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(searcher.searchRange(new int[]{3, 2, 2, 2}, 2)));
        System.out.println(Arrays.toString(searcher.searchRange(new int[]{2, 2, 2, 2}, 9)));
        System.out.println(Arrays.toString(searcher.searchRange(null, 9)));
    }

    @Test
    public void findClosestElements() {
        assert "[1, 2, 3, 4]".equals(searcher.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3).toString());
        assert "[1, 2, 3, 4]".equals(searcher.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1).toString());
        assert "[3, 3, 4]".equals(searcher.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5).toString());
        assert "[1, 3]".equals(searcher.findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2).toString());
        assert "[7, 8, 9]".equals(searcher.findClosestElements(new int[]{0, 1, 2, 7, 8, 9}, 3, 6).toString());
        assert "[3, 4, 6, 7]".equals(searcher.findClosestElements(new int[]{0, 2, 2, 3, 4, 6, 7, 8, 9, 9}, 4, 5).toString());
    }

    @Test
    public void myPow() {
        assert searcher.myPow(2, 3) == 8;
        assert searcher.myPow(3, 4) == 81;
        assert searcher.myPow(2, -1) == 0.5;
        assert searcher.myPow(2, -2) == 0.25;
        assert searcher.myPow(2, 10) == 1024;
    }

    @Test
    public void isPerfectSquare() {
        assert searcher.isPerfectSquare(16);
        assert !searcher.isPerfectSquare(14);
        assert !searcher.isPerfectSquare(2147483647);
        assert searcher.isPerfectSquare(2147395600);
    }

    @Test
    public void nextGreatestLetter() {
        assert searcher.nextGreatestLetter(new char[]{'a', 'c'}, 'b') == 'c';
        assert searcher.nextGreatestLetter(new char[]{'a', 'c', 'd'}, 'b') == 'c';
        assert searcher.nextGreatestLetter(new char[]{'a', 'b'}, 'c') == 'a';
        assert searcher.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') == 'c';
        assert searcher.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') == 'f';
        assert searcher.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'n', 'n'}, 'e') == 'n';
    }

    @Test
    public void intersection() {
        System.out.println(Arrays.toString(searcher.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(searcher.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
