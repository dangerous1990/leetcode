package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        ListNode step = head.next;
        while (head != null && step != null) {
            ListNode temp = step.next;
            current.next = step;
            step.next = head;
            current = head;

            head = temp;
            if (head == null) {
                break;
            }
            step = head.next;
        }
        if (head != null) {
            head.next = null;
            current.next = head;
        } else {
            current.next = null;
        }
        return fakeHead.next;
    }
}
