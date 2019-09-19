package org.dangerous.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        // 2 part
        // part one before m
        ListNode prev = new ListNode(0);
        ListNode fakePrevHead = prev;
        // part two reverse m n
        ListNode reverseHead = null;
        ListNode reverseTail = null;
        int count = 0;
        while (head != null) {
            count++;
            ListNode temp = head.next;
            if (count >= m && count <= n) {
                head.next = reverseHead;
                reverseHead = head;
                if (count == m) {
                    // record reverse tail
                    reverseTail = reverseHead;
                }
            }
            if (count < m) {
                prev.next = head;
                prev = head;
            }
            if (count > n) {
                reverseTail.next = head;
                reverseTail = head;
            }
            head = temp;
        }
        if (count == n) {
            reverseTail.next = null;
        }
        // concat reverse
        prev.next = reverseHead;
        return fakePrevHead.next;
    }

    public static void main(String[] args) {
        new ReverseLinkedListII().reverseBetween(ListNode.builder(new int[]{1, 2, 3, 4, 5}), 2, 4).print();
        new ReverseLinkedListII().reverseBetween(ListNode.builder(new int[]{1, 2, 3, 4, 5}), 1, 5).print();
    }
}
