package com.example.testapplication.algorithmtest;

import java.util.Stack;

/**
 * 两个栈实现队列
 * Created wangjinhao on 12/24/20.
 */
class QueueBy2Stack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            if(stack2.isEmpty()){
                return -1;
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        QueueBy2Stack queueBy2Stack = new QueueBy2Stack();
        queueBy2Stack.push(1);
        queueBy2Stack.push(2);
        queueBy2Stack.push(3);
        queueBy2Stack.push(4);
        System.out.println(queueBy2Stack.pop());
        System.out.println(queueBy2Stack.pop());
        System.out.println(queueBy2Stack.pop());
        System.out.println(queueBy2Stack.pop());
        System.out.println(queueBy2Stack.pop());
    }

}
