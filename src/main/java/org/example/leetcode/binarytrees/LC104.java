package org.example.LeetCode;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class LC104 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode root = new TreeNode(3, nine, twenty);
        System.out.println(queue(root));
    }

    private static int queue(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            while (count > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
                count--;
            }
            ans++;
        }
        return ans;
    }

    private static int maxDepth(TreeNode root) {
        return traverse(root);
    }

    private static int traverse(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(traverse(root.left), traverse(root.right)) + 1;
    }

}
