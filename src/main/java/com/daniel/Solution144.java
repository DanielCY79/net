package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * pre-order traversal
 *
 * @author Daniel Xia
 * @since 2019-06-16 19:38
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            resList.add(root.val);

            if(root.right != null){
                stack.add(root.right);
            }
            if(root.left != null){
                stack.add(root.left);
            }
        }
        return resList;
    }

}
