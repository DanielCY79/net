package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 21:45
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return head;
        }

        m = m - 1;
        n = n - 1;

        ListNode tmpHead = head;
        ListNode listNodeN = null;
        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;

        for(int i = 0; i <= n; i++){
            if(i == m - 1){
                prevHead = tmpHead;
            }
            if(i == n){
                listNodeN = tmpHead;
            }

            if(tmpHead == null){
                return head;
            }
            tmpHead = tmpHead.next;
        }

        if(m == 0){
            return reverseList(prevHead, prevHead.next, listNodeN);
        }else{
            reverseList(prevHead, prevHead.next, listNodeN);
            return head;
        }

    }

    public ListNode reverseList(ListNode prev, ListNode start, ListNode tail) {
        while (prev.next != tail) {
            prev.next = start.next;
            start.next = tail.next;
            tail.next = start;
            start = prev.next;
        }

        return start;
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

        Solution92 solution92 = new Solution92();
        n1 = solution92.reverseBetween(n1, 2, 4);
        ListNode.printLinkedList(n1);
    }


}
