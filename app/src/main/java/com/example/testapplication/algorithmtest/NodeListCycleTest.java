package com.example.testapplication.algorithmtest;

/**
 * 判断链表有没有环
 * 两个指针，一个每次前进一步，一个每次前进两部，有环的话，一定会相遇
 * Created wangjinhao on 12/24/20.
 */
class NodeListCycleTest {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode p = head;
            ListNode q = head;
            while(p!=null && p.next!=null){
                p = p.next.next;
                q = q.next;
                if(p==q){
                    return true;
                }

            }
            return false;
        }
    }
}
