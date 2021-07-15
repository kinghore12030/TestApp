package com.example.testapplication.algorithmtest;

import java.util.Stack;

/**
 * Created wangjinhao on 12/25/20.
 */
class ListNodeAddTest {

    public static void main(String[] args) {
        ListNodeAddTest test = new ListNodeAddTest();
        ListNode head1 = new ListNode();
        head1.value = 9;
        ListNode head2 = new ListNode();
        head2.value = 6;
        ListNode head11 = new ListNode();
        head11.value = 3;
        ListNode head111 = new ListNode();
        head111.value = 7;
        ListNode head22 = new ListNode();
        head22.value = 3;
        head1.next = head11;
        head11.next = head111;
        head2.next = head22;
        test.addInList(head1,head2);
    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        ListNode head3 = head1;
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        while(head1!= null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            stack1.push(head2);
            head2 = head2.next;
        }
        while(!stack1.isEmpty()&& !stack2.isEmpty()){
            stack3.push(((ListNode)stack1.pop()).value+((ListNode)stack2.pop()).value);
        }
        if(stack1.isEmpty() && !stack2.isEmpty()){
            stack3.push(((ListNode)stack2.pop()).value);
        }
        if(!stack1.isEmpty() && stack2.isEmpty()){
            stack3.push(((ListNode)stack1.pop()).value);
        }
        head3.next = null;
        for(int i = 1;i<stack3.size();i++){
            head3.next = (ListNode)stack3.pop();
            head3 = head3.next;
        }
        return head3;

    }
}
