package com.zhazhapan.demo.algorithm.leetcode.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author pantao
 * @since 2018/9/25
 **/
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, true);
    }
}
