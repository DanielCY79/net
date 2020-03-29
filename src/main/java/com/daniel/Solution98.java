package com.daniel;

import com.daniel.utils.TreeNode;

/**
 * @author Daniel Xia
 * @since 2019/7/4 14:49
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root).isBst;
    }

    private BstReturn process(TreeNode root) {
        if (root == null) {
            return null;
        }

        BstReturn left = process(root.left);
        BstReturn right = process(root.right);

        boolean isBst = true;
        if (left != null && (!left.isBst || left.max >= root.val)) {
            isBst = false;
        }
        if (right != null && (!right.isBst || right.min <= root.val)) {
            isBst = false;
        }

        int min = root.val;
        if (left != null) {
            min = Math.min(min, left.min);
        }
        int max = root.val;
        if (right != null) {
            max = Math.max(max, right.max);
        }

        return new BstReturn(min, max, isBst);
    }

    private class BstReturn {
        private int min;
        private int max;
        private boolean isBst;

        public BstReturn(int min, int max, boolean isBst) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }
}
