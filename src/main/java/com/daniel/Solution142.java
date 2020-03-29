package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/15 11:10
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode tmpHead = head;
        ListNode intersectionNode = checkCycle(head);
        if(intersectionNode == null){
            return null;
        }

        while(tmpHead != null && intersectionNode != null){

            if(tmpHead == intersectionNode){
                return tmpHead;
            }

            tmpHead = tmpHead.next;
            intersectionNode = intersectionNode.next;


        }

        return null;
    }

    public ListNode checkCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null &&fast.next.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n1;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n4;

        Solution142 solution142 = new Solution142();
        System.out.println(solution142.detectCycle(n1).val);
    }
}
