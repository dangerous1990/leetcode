package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.builder(new int[]{1, 2});
        new RotateList().rotateRight(head, 1).print();
        ListNode head2 = ListNode.builder(new int[]{1, 2, 3, 4, 5});
        new RotateList().rotateRight(head2, 2).print();
    }
}
