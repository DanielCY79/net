package com.daniel;

import com.daniel.utils.ListNode;

import java.lang.reflect.Field;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-15 20:18
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = new ListNode(-1);
        prev.next = head;
        head = prev;

        while(head != null && head.next != null){
            ListNode begin = head.next;
            if(begin.next != null && begin.val == begin.next.val){
                ListNode end = begin.next;
                while(end.next != null && end.val == end.next.val){
                    end = end.next;
                }
                begin.next = end.next;
            }else{
                head = head.next;
            }
        }

        return prev.next;

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;

        Solution82 solution82 = new Solution82();
        ListNode.printLinkedList(solution82.deleteDuplicates(n1));

        System.out.println("------");
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);

        n9.next = n10;
        ListNode nT = n9;
        nT.next = null;
        nT.val = -1000;
        System.out.println("^^^^^^");

        Integer x = 2;
        Integer y = x;
        x = 100;
//        Field f1 = x.getClass().getDeclaredField("value");
//        f1.setAccessible(true);
//        f1.set(x, 100);
        System.out.println();
    }
}
