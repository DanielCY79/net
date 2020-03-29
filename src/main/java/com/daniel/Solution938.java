package com.daniel;

import com.daniel.utils.TreeNode;

/**
 * @author Daniel Xia
 * @since 2019/6/21 10:19
 */
public class Solution938 {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        return process(root, L, R);
    }

    public int process(TreeNode node, int L, int R) {
        if(node == null){
            return 0;
        }
        if(node.val > R){
           return process(node.left, L, R);
        }else if(node.val < L){
            return process(node.right, L, R);
        }else{
            return sum = node.val + process(node.left, L, R) + process(node.right, L, R);
        }
    }
}
