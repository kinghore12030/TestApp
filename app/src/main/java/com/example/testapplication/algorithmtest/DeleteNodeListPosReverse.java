package com.example.testapplication.algorithmtest;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 * 给出的链表为:1->2->3->4->5, n= 2.
 * 删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是有效的
 * 请给出请给出时间复杂度为 O(n)的算法
 * <p>
 * <p>
 * 因为是删除倒数第n个节点，所以首先遍历链表的长度，之后再把循环出正数第length-n个节点，将p节点的next域指向p.next.next地址
 * Created wangjinhao on 12/25/20.
 */
class DeleteNodeListPosReverse {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        if (len == n){
            return head.next;
        }
        cur = head;
        int temp = len - n;
        while (temp > 1) {
            cur = cur.next;
            temp--;
        }
        cur.next = cur.next.next;
        return head;
    }
}
