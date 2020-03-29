package com.daniel;

import com.daniel.utils.ListNode;

/**
 * @author Daniel Xia
 * @since 2019-06-29 22:38
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode curPrev = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curPrev.next = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                curPrev.next = l2;
                l2 = l2.next;
            }
            curPrev = curPrev.next;
        }

        while (l1 != null) {
            curPrev.next = l1;
            l1 = l1.next;
            curPrev = curPrev.next;
        }
        while (l2 != null) {
            curPrev.next = l2;
            l2 = l2.next;
            curPrev = curPrev.next;
        }

        return prev.next;
    }
}
