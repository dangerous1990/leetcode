package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (n-- != 0) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return head.next;
        }
        while (fastNode != null) {
            // the end
            if (fastNode.next == null) {
                slowNode.next = slowNode.next == null ? null : slowNode.next.next;
                break;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return head;
    }
}
