package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree
 */
public class SymmetricTree {

    /**
     * 层序遍历 判断每一层是否镜像
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        Map<Integer, List<Integer>> m = new HashMap<>();
        travel(root, 0, m);
        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
            if (e.getKey() > 0 && e.getValue().size() % 2 != 0) {
                return false;
            }
            if (e.getKey() > 0) {
                for (int i = 0, j = e.getValue().size() - 1; i < j; i++, j--) {
                    if (e.getValue().get(i) != e.getValue().get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 递归方式 遍历2颗树t1,t2 t1的左子树=t2的右子树 t1的右子树=t2的左子树
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    // 使用队列 两个连续入列的元素需要相等
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    private void travel(TreeNode root, int level, Map<Integer, List<Integer>> m) {
        if (m.get(level) == null) {
            m.put(level, new ArrayList<>());
        }
        if (root == null) {
            m.get(level).add(null);
            return;
        } else {
            m.get(level).add(root.val);
        }
        travel(root.left, level + 1, m);
        travel(root.right, level + 1, m);
    }

}
