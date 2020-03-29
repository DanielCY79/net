package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-15 20:46
 */
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curIndex = prev;

        ListNode begin = null;
        ListNode end = null;
        while (curIndex != null && curIndex.next != null) {

            begin = curIndex.next;
            if (begin.next != null && begin.next.val == begin.val) {

                end = begin.next;
                while (end.next != null && end.next.val == end.val) {
                    end = end.next;
                }
                begin.next = end.next;

            } else {
                curIndex = curIndex.next;
            }
        }

        return prev.next;
    }

}
