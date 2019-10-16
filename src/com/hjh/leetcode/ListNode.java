package com.hjh.leetcode;

/**
 * @author hejiahao
 * @version 1.0
 * @date 2019/7/2 11:27
 * @projct_name leetcode
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val=x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
