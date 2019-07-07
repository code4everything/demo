package com.zhazhapan.demo.algorithm.leetcode.contest.c144;

/**
 * @author pantao
 * @since 2019/7/7
 */
public class Contest5117 {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
