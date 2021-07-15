package com.example.testapplication.algorithmtest;

/**
 * Created wangjinhao on 2021/6/22.
 */
class ListNodeAdd {


    public static void main(String[] args) {
        ListNodeAdd listNodeAdd = new ListNodeAdd();
        ListNode l1 = new ListNode();
        ListNode l11 = new ListNode();
        ListNode l12 = new ListNode();
        ListNode l13 = new ListNode();
        ListNode l14 = new ListNode();
        ListNode l15 = new ListNode();
        ListNode l16 = new ListNode();
        l1.value = 9;
        l1.next = l11;
        l11.value = 9;
        l11.next = l12;
        l12.value = 9;
        l12.next = l13;
        l13.value = 9;
        l13.next = l14;
        l14.value = 9;
        l14.next = l15;
        l15.value = 9;
        l15.next = l16;
        l16.value = 9;

        ListNode l2 = new ListNode();
        ListNode l21 = new ListNode();
        ListNode l22 = new ListNode();
        ListNode l23 = new ListNode();
        l2.value = 9;
        l2.next = l21;
        l21.value = 9;
        l21.next = l22;
        l22.value = 9;
        l22.next = l23;
        l23.value = 9;
        listNodeAdd.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        ListNode head = null;
        ListNode node = null;

        node = new ListNode();
        int lease = 0;
        head = node;
        while(l1 != null && l2 != null){
            node.value = (l1.value + l2.value +lease)%10;
            lease = (l1.value + l2.value+lease)/10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null && l2 != null) {
                ListNode nextNode = new ListNode();
                node.next = nextNode;
                node = node.next;
            }
        }
        if(l1 == null && l2 == null){
            if (lease != 0) {
                ListNode nextNode = new ListNode();
                node.next = nextNode;
                node = node.next;
                node.value = lease;
            }
            return head;
        }
        if(l1 == null && l2 != null){
            while (l2 != null){
                ListNode nextNode = new ListNode();
                nextNode.value = (l2.value + lease)%10;
                lease = (l2.value + lease)/10;
                node.next = nextNode;
                node = node.next;
            }
            return head;
        }
        if(l2 == null && l1 != null){
            while (l1 != null){
                ListNode nextNode = new ListNode();
                nextNode.value = (l1.value + lease)%10;
                lease = (l1.value + lease)/10;
                node.next = nextNode;
                node = node.next;
            }
            return head;
        }
        return head;
    }
}
