package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-29 21:55
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> innerList = new ArrayList<>();
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()){
            root = queue.poll();
            innerList.add(root.val);
            size--;
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
            if(size == 0){
                List<Integer> resInnerList = innerList;
                resList.add(innerList);
                innerList = new ArrayList<>();
                size = queue.size();
            }
        }

        return resList;
    }
}
