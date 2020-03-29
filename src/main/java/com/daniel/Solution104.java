package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.Stack;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/18 15:59
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int maxDepth = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while(!stack.empty()){
            Pair curPair = stack.pop();

            maxDepth = Math.max(maxDepth, curPair.depth);
            if(curPair.node.right != null){
                stack.push(new Pair(curPair.node.right, curPair.depth + 1));
            }
            if(curPair.node.left != null){
                stack.push(new Pair(curPair.node.left, curPair.depth + 1));
            }
        }

        return maxDepth;
    }

    private static class Pair{
        private TreeNode node;
        private int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
