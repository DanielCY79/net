package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 21:41
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

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
                res = reverseList(prevHead, prevHead.next, tail, k);
            } else {
                reverseList(prevHead, prevHead.next, tail, k);
            }

            prevHead = nextPrev;
            indexNode = nextPrev;
            count++;
        }
        return res;
    }

    public ListNode reverseList(ListNode prev, ListNode start, ListNode tail, int k) {
        while (prev.next != tail) {
            prev.next = start.next;
            start.next = tail.next;
            tail.next = start;
            start = prev.next;
        }

        return start;
    }
}
