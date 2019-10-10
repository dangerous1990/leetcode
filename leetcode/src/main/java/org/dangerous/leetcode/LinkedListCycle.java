package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    /**
     * 慢指针走一步
     * 快指针走两步
     * 如果存在环
     * 快指针一定会追上慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new LinkedListCycle().hasCycle(ListNode.builder(new int[]{3, 2, 0, -4})));
    }

}
