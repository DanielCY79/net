package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-29 18:47
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode resRoot = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();

            TreeNode tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;

            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }

        return resRoot;
    }
}
