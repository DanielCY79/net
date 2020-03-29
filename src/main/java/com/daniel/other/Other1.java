package com.daniel.other;

import java.util.Stack;

/**
 * Reverse a stack without external memory
 *
 * @author Daniel Xia
 * @since 2019-07-03 19:32
 */
public class Other1 {

    public void reverseStack(Stack<Integer> stack){
        if(stack == null || stack.empty()){
            return;
        }

        int last = getLast(stack);
        reverseStack(stack);
        stack.push(last);
    }

    public int getLast(Stack<Integer> stack){
        int cur = stack.pop();
        if(stack.empty()){
            return cur;
        }

        int last = getLast(stack);
        stack.push(cur);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        Other1 other1 = new Other1();
        other1.reverseStack(stack);
        System.out.println();
    }
}
