package com.daniel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/18 11:08
 */
public class Solution155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }


}

class MinStack {

    private List<Integer> stackList;
    private List<Integer> minStackList;
    private int index;
    private int minIndex;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackList = new ArrayList<>();
        minStackList = new ArrayList<>();
        index = -1;
        minIndex = -1;
    }

    public void push(int x) {
        stackList.add(x);
        index++;
        if (minIndex == -1) {
            minStackList.add(index);
            minIndex++;
        } else {
            if (x <= stackList.get(minStackList.get(minIndex))) {
                minStackList.add(index);
                minIndex++;
            }
        }
    }

    public void pop() {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        if (stackList.get(index) == stackList.get(minStackList.get(minIndex))) {
            minStackList.remove(minIndex--);
        }
        stackList.remove(index--);
    }

    public int top() {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        return stackList.get(index);

    }

    public int getMin() {
        if (minIndex == -1) {
            throw new IllegalArgumentException();
        }
        return stackList.get(minStackList.get(minIndex));
    }
}