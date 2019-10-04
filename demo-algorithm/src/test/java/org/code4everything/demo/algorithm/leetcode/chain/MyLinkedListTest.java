package org.code4everything.demo.algorithm.leetcode.chain;

import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        assert 2 == linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        assert 3 == linkedList.get(1);            //返回3
    }
}
