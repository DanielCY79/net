package com.daniel;

import com.daniel.utils.TreeNode;

/**
 * @author Daniel Xia
 * @since 2019-07-04 19:23
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
