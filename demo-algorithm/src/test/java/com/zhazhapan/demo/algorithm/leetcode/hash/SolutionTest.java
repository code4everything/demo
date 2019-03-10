package com.zhazhapan.demo.algorithm.leetcode.hash;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isHappy() {
        assert !solution.isHappy(2);
        assert solution.isHappy(996655423);
        assert solution.isHappy(19);
    }

    @Test
    public void isIsomorphic() {
        assert solution.isIsomorphic("add", "egg");
        assert !solution.isIsomorphic("foo", "bar");
        assert solution.isIsomorphic("paper", "title");
        assert !solution.isIsomorphic("ab", "aa");
    }

    @Test
    public void findRestaurant() {
        Console.log(solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter " + "Steakhouse", "Shogun"}));
        Console.log(solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"}));
        Console.log(solution.findRestaurant(new String[]{"1", "2"}, new String[]{"2", "1"}));
    }

    @Test
    public void firstUniqChar() {
        assert 0 == solution.firstUniqChar("leetcode");
        assert 2 == solution.firstUniqChar("loveleetcode");
    }

    @Test
    public void containsNearbyDuplicate() {
        assert solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        assert solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
        assert !solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    @Test
    public void groupAnagrams() {
        Console.log(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        Console.log(solution.groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max"
                , "doc"}));
        Console.log(solution.groupAnagrams(new String[]{"run", "had", "lot", "kim", "fat", "net", "fin", "rca", "chi"
                , "lei", "lox", "iva", "liz", "hug", "hot", "irk", "lap", "tan", "tux", "yuk", "hep", "map", "ran",
                "ell", "kit", "put", "non", "aol", "add", "lad", "she", "job", "mes", "pen", "vic", "fag", "bud",
                "ken", "nod", "jam", "coy", "hui", "sue", "nap", "ton", "coy", "rut", "fit", "cut", "eta", "our",
                "oho", "zip"}));
        Console.log(solution.groupAnagrams(new String[]{"tho", "tin", "erg", "end", "pug", "ton", "alb", "mes", "job"
                , "ads", "soy", "toe", "tap", "sen", "ape", "led", "rig", "rig", "con", "wac", "gog", "zen", "hay",
                "lie", "pay", "kid", "oaf", "arc", "hay", "vet", "sat", "gap", "hop", "ben", "gem", "dem", "pie",
                "eco", "cub", "coy", "pep", "wot", "wee"}));
    }

    @Test
    public void numJewelsInStones() {
        assert 3 == solution.numJewelsInStones("aA", "aAAbbbb");
    }
}