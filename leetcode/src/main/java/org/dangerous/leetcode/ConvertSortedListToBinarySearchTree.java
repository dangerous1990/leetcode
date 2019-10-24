package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class ConvertSortedListToBinarySearchTree {

    private List<Integer> values = new ArrayList<Integer>();


    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    /**
     * 转成数组使用 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * @param left
     * @param right
     * @return
     */
    private TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        this.mapListToValues(head);

        // Convert the array to
        return convertListToBST(0, this.values.size() - 1);
    }
}
