package org.dangerous.leetcode;

/**
 * Created by limeng on 17-6-3.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode builder(int[] vals) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int count = 0;
        while (count < vals.length) {
            cur.next = new ListNode(vals[count]);
            cur = cur.next;
            count++;
        }
        return head.next;
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}