package org.code4everything.demo.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 集合工具类
 *
 * @author pantao
 * @since 2019/10/4
 */
public class ListsDemo {

    public static void main(String[] args) {
        // 新建List
        List<String> list1 = Lists.newArrayList("hello", "guava");
        List<String> list2 = Lists.newLinkedList(Arrays.asList("guava", "hello"));
        // 不可变列表
        assert list1.equals(ImmutableList.copyOf(Lists.reverse(list2)));
    }
}
