package com.zhazhapan.demo.test;

/**
 * @author pantao
 * @since 2019/3/6
 **/
public class MathTest {

    public static void main(String[] args) {
        assert -3 == Math.round(-2.6);
        assert 3 == Math.round(2.6);
        // && 的优先级大于 ||
        assert true || true && false;
    }
}
