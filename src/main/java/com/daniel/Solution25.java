package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 20:41
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;

        ListNode indexNode = prevHead;
        ListNode tail = null;
        ListNode nextPrev = null;

        ListNode res = head;

        int index = 0;
        int count = 0;
        while (true) {
            nextPrev = prevHead.next;
            index = 0;
            while (index < k && indexNode != null) {
                indexNode = indexNode.next;
                index++;
            }
            if (indexNode == null) {
                break;
            }
            tail = indexNode;

            if (count == 0) {
                res = reverseList(prevHead, prevHead.next, tail);
            } else {
                reverseList(prevHead, prevHead.next, tail);
            }

            prevHead = nextPrev;
            indexNode = nextPrev;
            count++;
        }
        return res;
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

        Solution25 solution25 = new Solution25();
        n1 = solution25.reverseKGroup(n1, 3);
        ListNode.printLinkedList(n1);
    }
}
