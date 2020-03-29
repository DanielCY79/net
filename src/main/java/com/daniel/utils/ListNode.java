package com.daniel.utils;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 20:14
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println();
    }
}
