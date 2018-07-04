package org.dangerous.offer;

import org.dangerous.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by limeng on 18-7-4.
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>(0);
        }
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
