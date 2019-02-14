package com.zhazhapan.demo.algorithm.leetcode.chain;

/**
 * @author pantao
 * @since 2019/2/14
 **/
public class MyLinkedList {

    private MyNode head;

    private MyNode tail;

    private int size = 0;

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        MyNode curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        MyNode node = new MyNode(val);
        if (size == 0) {
            tail = node;
        } else {
            node.next = head;
        }
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        size++;
        MyNode node = new MyNode(val);
        if (tail == null) {
            tail = node;
        } else {
            tail.next = tail = node;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            MyNode curr = head;
            while (--index > 0) {
                curr = curr.next;
            }
            MyNode next = curr.next;
            curr.next = new MyNode(val);
            curr.next.next = next;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            MyNode curr = head;
            int i = 0;
            for (; i < index; i++) {
                if (i == 0) {
                    continue;
                }
                curr = curr.next;
            }
            size--;
            if (i == 0) {
                head = head.next;
            } else if (i == size) {
                curr.next = tail.next;
                tail = curr;
            } else {
                curr.next = curr.next.next;
            }
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder().append(head.val);
        MyNode curr = head.next;
        while (curr != null) {
            builder.append(" -> ").append(curr.val);
            curr = curr.next;
        }
        return builder.toString();
    }

    private class MyNode {

        int val;

        MyNode next;

        MyNode(int val) {
            this.val = val;
        }
    }
}
