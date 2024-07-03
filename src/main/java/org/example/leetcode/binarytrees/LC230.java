package org.example.LeetCode;

import java.util.Stack;

class LC230 {

    private static class TreeNode {
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
        TreeNode one = new TreeNode(1, null, null);
        TreeNode two = new TreeNode(2, one, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode five = new TreeNode(3, three, six);
        System.out.println(kthSmallest(five, 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2]; // 0: kth smallest value, 1: current count

        inorderTraversal(root, k, result);

        return result[0];
    }

    private static void inorderTraversal(TreeNode node, int k, int[] result) {
        if (node == null || result[1] >= k) {
            return;
        }
        inorderTraversal(node.left, k, result);

        result[1]++;  // Increment the count

        // Check if the current element is the kth smallest
        if (result[1] == k) {
            result[0] = node.val;
            return;
        }

        inorderTraversal(node.right, k, result);
    }

    public int stack(TreeNode root, int k) { //  LC94, LC98, LC230
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }

}
