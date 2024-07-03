package org.example.leetcode;

import java.util.Stack;

public class LC617 {

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
        TreeNode n15 = new TreeNode(5, null, null);
        TreeNode n13 = new TreeNode(3, n15, null);
        TreeNode n12 = new TreeNode(2, null, null);
        TreeNode root1 = new TreeNode(1, n13, n12);

        TreeNode n24 = new TreeNode(4, null, null);
        TreeNode n27 = new TreeNode(7, null, null);
        TreeNode n21 = new TreeNode(1, null, n24);
        TreeNode n23 = new TreeNode(3, null, n27);
        TreeNode root2 = new TreeNode(2, n21, n23);

        System.out.println(iterativeTraverse(root1, root2));
    }

    public static TreeNode iterativeTraverse(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            if (nodes[1] == null) continue;

            nodes[0].val += nodes[1].val;

            if (nodes[0].left == null) {
                nodes[0].left = nodes[1].left;
            } else {
                stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
            }

            if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else {
                stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            }
        }

        return root1;
    }

    public static TreeNode improvedRecursiveTraverse(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private static TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        node1.val += node2.val;
        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);
        return node1;
    }

    public static TreeNode recursiveTraverse(TreeNode root1, TreeNode root2) { // O(n), O(n) - из-за стека? stack overflow
        return sumNode(root1, root2);
    }

    public static TreeNode sumNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return null;
        else if (node1 == null) node1 = new TreeNode(node2.val, null, null);
        else if (node2 == null) return node1;
        else node1.val += node2.val;
        node1.left = sumNode(node1.left, node2.left);
        node1.right = sumNode(node1.right, node2.right);
        return node1;
    }


}
