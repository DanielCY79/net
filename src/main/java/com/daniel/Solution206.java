package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 20:16
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;

        ListNode start = head;
        while(start.next != null){

            start = start.next;
        }
        ListNode tail = start;
        start = head;

        while(prevHead.next != tail){
            prevHead.next = start.next;
            start.next = tail.next;
            tail.next = start;
            start = prevHead.next;
        }

        return prevHead.next;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution206 solution206 = new Solution206();
        n1 = solution206.reverseList(n1);
        ListNode.printLinkedList(n1);
    }
}
