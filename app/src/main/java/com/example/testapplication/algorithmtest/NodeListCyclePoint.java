package com.example.testapplication.algorithmtest;

/**
 * 题目描述：对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 快慢指针方法:将两指针分别放在链表头（X）和相遇位置（Z），并改为相同速度推进，则两指针在环开始位置相遇（Y），如图所示。
 * Created wangjinhao on 12/25/20.
 */
class NodeListCyclePoint {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {   //利用快慢指针找相遇点
                ListNode slow2 = head;  //设置以相同速度的新指针从起始位置出发
                while (slow2 != slow) {  //未相遇循环。
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
