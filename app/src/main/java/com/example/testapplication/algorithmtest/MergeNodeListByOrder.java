package com.example.testapplication.algorithmtest;

/**
 * 合并两个有序链表，合并后依然有序
 * Created wangjinhao on 12/25/20.
 */
class MergeNodeListByOrder {

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode node = null;
        ListNode head = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.value < l2.value) {
            node = l1;
            l1 = l1.next;
        } else {
            node = l2;
            l2 = l2.next;
        }
        head = node;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        return head;
    }
}
