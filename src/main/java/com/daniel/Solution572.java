package com.daniel;

import com.daniel.utils.TreeNode;

/**
 * @author Daniel Xia
 * @since 2019-07-04 20:32
 */
public class Solution572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }

        return check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
