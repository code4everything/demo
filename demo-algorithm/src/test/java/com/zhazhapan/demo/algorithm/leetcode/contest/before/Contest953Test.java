package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest953;
import org.junit.Test;

public class Contest953Test {

    @Test
    public void isAlienSorted() {
        Contest953 contest953 = new Contest953();
        assert contest953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        assert !contest953.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz");
        assert !contest953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
        assert contest953.isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz");
    }
}
