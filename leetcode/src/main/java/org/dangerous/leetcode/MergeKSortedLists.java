package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int size = (lists.length + 1) / 2;
        ListNode[] result = new ListNode[size];
        for (int i = 0, j = lists.length - 1; i < j; i++, j--) {
            result[i] = mergeTwoLists(lists[i], lists[j]);
        }
        if (lists.length % 2 == 1) {
            result[size - 1] = lists[size - 1];
        }
        return mergeKLists(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return fakeHead.next;
    }


}
