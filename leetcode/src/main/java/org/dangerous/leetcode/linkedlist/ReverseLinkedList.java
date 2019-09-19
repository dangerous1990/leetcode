package org.dangerous.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        return reverse(head, next);

    }

    /**
     * recursively
     *
     * @param x
     * @param y
     * @return
     */
    private ListNode reverse(ListNode x, ListNode y) {
        if (y == null) {
            return x;
        }
        ListNode next = y.next;
        y.next = x;
        return reverse(y, next);
    }

    /**
     * iterate
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;

    }

    public static void main(String[] args) {
        ListNode x = ListNode.builder(new int[]{1, 2, 3, 4, 5});
        ListNode y = ListNode.builder(new int[]{1, 2, 3, 4, 5});
        new ReverseLinkedList().reverseList(x).print();
        new ReverseLinkedList().reverseList2(y).print();
    }
}
