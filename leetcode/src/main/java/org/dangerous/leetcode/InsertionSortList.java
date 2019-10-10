package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0); // 排序的链表
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = null;
            ListNode sortHead = fakeHead.next;
            if (sortHead == null) {
                fakeHead.next = next;
            } else {
                while (sortHead != null) {
                    // 大于最后一个元素
                    if (sortHead.next == null && next.val >= sortHead.val) {
                        sortHead.next = next;
                        break;
                    }
                    // 小于当前元素
                    if (next.val <= sortHead.val) {
                        fakeHead.next = next;
                        fakeHead.next.next = sortHead;
                        break;
                    }
                    // 在两个元素之间
                    if (next.val >= sortHead.val && next.val <= sortHead.next.val) {
                        ListNode t = sortHead.next;
                        sortHead.next = next;
                        sortHead.next.next = t;
                        break;
                    }

                    sortHead = sortHead.next;
                }
            }
            next = temp;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        new InsertionSortList().insertionSortList(ListNode.builder(new int[]{4, 2, 1, 3})).print();
        new InsertionSortList().insertionSortList(ListNode.builder(new int[]{-1, 5, 3, 4, 0})).print();
    }
}
