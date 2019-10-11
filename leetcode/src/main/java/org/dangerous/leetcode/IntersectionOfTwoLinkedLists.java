package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
