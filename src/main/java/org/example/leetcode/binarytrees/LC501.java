package org.example.leetcode.binarytrees;

public class LC503 {

    private List<Integer> mode = new ArrayList<>();
    private int max_count = 0;
    private int prev = -1;
    private int count = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        mode.clear();
        max_count = 0;
        prev = -1;
        count = 0;

        inorder(root);

        int[] result = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++) {
            result[i] = mode.get(i);
        }

        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev == -1) {
            prev = root.val;
            count = 1;
        } else if (prev == root.val) {
            count++;
        } else {
            prev = root.val;
            count = 1;
        }

        if (count > max_count) {
            max_count = count;
            mode = new ArrayList<>();
            mode.add(root.val);
        } else if (count == max_count) {
            mode.add(root.val);
        }

        inorder(root.right);
    }

}
