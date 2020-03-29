package com.daniel;

import com.daniel.utils.TreeNode;

/**
 * check balance binary tree
 *
 * @author Daniel Xia
 * @since 2019/7/4 14:12
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root).isBalanced;
    }

    private BalancedReturn process(TreeNode root) {
        if (root == null) {
            return new BalancedReturn(0, true);
        }

        BalancedReturn left = process(root.left);
        BalancedReturn right = process(root.right);

        boolean isBalanced = false;
        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2) {
            isBalanced = true;
        }

        int height = Math.max(left.height, right.height) + 1;

        return new BalancedReturn(height, isBalanced);
    }

    private class BalancedReturn {
        private int height;
        private boolean isBalanced;

        public BalancedReturn(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

}
