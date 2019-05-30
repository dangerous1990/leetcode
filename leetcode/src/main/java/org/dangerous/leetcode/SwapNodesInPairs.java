package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        ListNode step = head.next;
        if (step == null) {
            return head;
        }
        while (step != null && head != null) {
            ListNode temp = step.next;
            current.next = step;
            step.next = head;
            current = head;
            if (temp == null) {
                head = null;
                break;
            }
            head = temp;
            step = temp.next;
        }
        if (head != null) {
            head.next = null;
            current.next = head;

        } else {
            current.next = null;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
//        a.next.next.next.next = new ListNode(5);
        ListNode b = new SwapNodesInPairs().swapPairs(a);
        while (b != null) {
            System.out.print(b.val);
            b = b.next;
        }
        System.out.println();

    }
}
