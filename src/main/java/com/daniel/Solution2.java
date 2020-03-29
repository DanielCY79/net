package com.daniel;

import com.daniel.utils.ListNode;

import java.util.Stack;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/18 14:41
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headL1 = l1;
        ListNode headL2 = l2;

        ListNode sumListNodePrev = new ListNode(-1);
        ListNode resListNodePrev = sumListNodePrev;
        int count = 0;
        while(headL1 != null && headL2 != null){
            int sum = headL1.val + headL2.val + count;
            count = sum / 10;
            int mod = sum % 10;
            resListNodePrev.next = new ListNode(mod);
            resListNodePrev = resListNodePrev.next;

            headL1 = headL1.next;
            headL2 = headL2.next;
        }
        while(headL1 != null){
            int sum = headL1.val + count;
            count = sum / 10;
            int mod = sum % 10;

            resListNodePrev.next = new ListNode(mod);
            resListNodePrev = resListNodePrev.next;

            headL1 = headL1.next;
        }
        while(headL2 != null){
            int sum = headL2.val + count;
            count = sum / 10;
            int mod = sum % 10;

            resListNodePrev.next = new ListNode(mod);
            resListNodePrev = resListNodePrev.next;

            headL2 = headL2.next;
        }

        if(count > 0){
            resListNodePrev.next = new ListNode(count);
            resListNodePrev = resListNodePrev.next;
        }

        return sumListNodePrev.next;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode n1 = new ListNode(5);

        ListNode n2 = new ListNode(5);

        ListNode.printLinkedList(solution2.addTwoNumbers(n1, n2));
    }
}
