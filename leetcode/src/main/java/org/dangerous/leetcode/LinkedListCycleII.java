package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(new LinkedListCycleII().detectCycle(ListNode.builder(new int[]{3, 2, 0, -4})));
    }

}
