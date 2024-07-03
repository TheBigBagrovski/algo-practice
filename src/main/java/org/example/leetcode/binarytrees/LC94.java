package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class LC94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return recursive(root, list);
    }

    public List<Integer> recursive(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        recursive(root.left, list);
        list.add(root.val);
        recursive(root.right, list);
        return list;
    }

    public List<Integer> stack(TreeNode root) { //  LC94, LC98, LC230
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

}
