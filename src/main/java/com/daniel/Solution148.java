package com.daniel;

import com.daniel.utils.ListNode;

/**
 * @author Daniel Xia
 * @since 2019-07-06 21:53
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    void quickSort(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) return;
        int pivot = head.val;
        ListNode left = head, cur = head.next;
        while (cur != tail) {
            if (cur.val < pivot) {
                left = left.next;
                swap(left, cur);
            }
            cur = cur.next;
        }
        swap(head, left);
        quickSort(head, left);
        quickSort(left.next, tail);
    }

    private void swap(ListNode left, ListNode right) {
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
    }
}
