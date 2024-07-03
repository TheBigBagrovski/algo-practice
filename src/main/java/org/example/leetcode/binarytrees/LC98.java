package org.example.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class LC98 {

    private class TreeNode {
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

    }

    public boolean recursive(TreeNode root) {
        return recursive(root, Long.MIN_VALUE/*, Long.MAX_VALUE*/);
    }

    public boolean recursive(TreeNode root, long minVal/*, long maxVal*/) {
        if (root == null) return true;
        if (/*root.val >= maxVal ||*/ root.val <= minVal) return false;
        return recursive(root.left, minVal/*, root.val*/) && recursive(root.right, root.val/*, maxVal*/);
    }

    public boolean stack(TreeNode root) { //  LC94, LC98, LC230
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
