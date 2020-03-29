package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-14 22:18
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int aLength = 0;
        int bLength = 0;
        ListNode tmpHeadA = headA;
        ListNode tmpHeadB = headB;
        while(tmpHeadA != null){
            aLength++;
            tmpHeadA = tmpHeadA.next;
        }
        while(tmpHeadB != null){
            bLength++;
            tmpHeadB = tmpHeadB.next;
        }
        tmpHeadB = headB;
        tmpHeadA = headA;

        ListNode intersection = null;
        int diff = 0;
        int remaining = 0;
        if(bLength > aLength){
            diff = bLength - aLength;
            remaining = aLength;
            for(int i = 0; i < diff; i++){
                tmpHeadB = tmpHeadB.next;
            }
        }else{
            diff = aLength - bLength;
            remaining = bLength;
            for(int i = 0; i < diff; i++){
                tmpHeadA = tmpHeadA.next;
            }
        }

        for(int i = 0; i < remaining; i++){
            if(tmpHeadA == tmpHeadB){
                intersection = tmpHeadA;
                break;
            }

            tmpHeadA = tmpHeadA.next;
            tmpHeadB = tmpHeadB.next;
        }

        return intersection;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);
        ListNode n13 = new ListNode(13);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n11.next = n12;
        n12.next = n13;
        n13.next = n3;

        Solution160 solution160 = new Solution160();
        ListNode node = solution160.getIntersectionNode(n1, n11);
        System.out.println(node.val);
    }
}
