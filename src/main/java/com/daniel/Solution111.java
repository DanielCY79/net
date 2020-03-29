package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.Stack;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/19 16:05
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int minDepth = Integer.MAX_VALUE;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while(!stack.empty()){
            Pair curPair = stack.pop();

            if(curPair.node.right != null){
                stack.push(new Pair(curPair.node.right, curPair.depth + 1));
            }
            if(curPair.node.left != null){
                stack.push(new Pair(curPair.node.left, curPair.depth + 1));
            }

            if(curPair.node.right == null && curPair.node.left == null){
                minDepth = Math.min(minDepth, curPair.depth);
            }
        }

        return minDepth;
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
