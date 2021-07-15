package com.example.testapplication.algorithmtest;

/**
 * 单向链表反转
 * Created wangjinhao on 12/24/20.
 */
class NodeReverseTest {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode re = ReverseList(listNode1);
    }

    public static ListNode ReverseList(ListNode head) {
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode pre = null;
        //初始化p指针，用于记录当前结点的下一个结点地址
        ListNode p = null;
        //head指向null时，循环终止。
        while (head != null) {
            //先用p指针记录当前结点的下一个结点地址。
            p = head.next;
            //让被当前结点与链表断开并指向前一个结点pre。
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向p(保存着原链表中head的下一个结点地址)
            head = p;
        }
        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }

}
