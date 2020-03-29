package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Daniel Xia
 * @since 2019-06-16 22:15
 */
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            resStack.push(root.val);

            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!resStack.isEmpty()) {
            resList.add(resStack.pop());
        }
        return resList;
    }

}
