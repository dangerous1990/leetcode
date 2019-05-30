package org.dangerous.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode fakeNode = new ListNode(0);
        ListNode cur = fakeNode;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    cur.next = stack.pop();
                    cur = cur.next;
                }
            }

        }
        for (int i = stack.size() - 1; i >=0; i--) {
            cur.next = stack.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return fakeNode.next;
    }
}
