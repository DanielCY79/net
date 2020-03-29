package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel Xia
 * @since 2019/7/4 14:37
 */
public class Solution958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root.right != null && root.left == null) {
                return false;
            }
            if (leaf && (root.left != null || root.right != null)) {
                return false;
            }
            if (root.left == null || root.right == null) {
                leaf = true;
            }
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return true;
    }

}
