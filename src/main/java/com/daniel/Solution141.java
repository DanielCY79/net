package com.daniel;

import com.daniel.utils.ListNode;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/15 11:05
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

}
