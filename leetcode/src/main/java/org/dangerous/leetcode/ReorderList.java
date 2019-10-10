package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 计算长度
        int count = count(head);
        if (count <= 2) {
            return;
        }
        int mid = count / 2;
        int index = 0;
        ListNode tail = null;
        ListNode next = head;
        // 翻转后一半
        while (next != null) {
            index++;
            if (index == mid) {
                ListNode temp = next.next;
                next.next = null;
                next = temp;
            }
            if (index > mid) {
                ListNode temp = next.next;
                next.next = tail;
                tail = next;
                next = temp;
            }
            if (index < mid) {
                next = next.next;
            }
        }
        // 前一半和后一半穿插连接在一起
        ListNode preOrder = head;
        ListNode postOrder = tail;
        while (preOrder != null) {
            ListNode tempPreOrder = preOrder.next;
            ListNode tempPostOrder = postOrder.next;

            preOrder.next = postOrder;
            if (tempPreOrder != null) {
                postOrder.next = tempPreOrder;
            }

            preOrder = tempPreOrder;
            postOrder = tempPostOrder;
        }
        return;
    }

    private int count(ListNode head) {
        ListNode next = head;
        int count = 0;
        while (next != null) {
            next = next.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.builder(new int[]{1, 2, 3, 4, 5});
        new ReorderList().reorderList(head);
        head.print();
    }
}
