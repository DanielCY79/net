package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel Xia
 * @since 2019/6/19 14:04
 */
public class Solution662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> indexList = new LinkedList<>();

        queue.add(root);
        indexList.add(1);
        int size = 1;
        int maxLength = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            int index = indexList.poll();
            size--;

            if (root.left != null) {
                queue.add(root.left);
                indexList.add(2 * index);
            }
            if (root.right != null) {
                queue.add(root.right);
                indexList.add(2 * index + 1);
            }

            if (size == 0) {
                if (indexList.size() > 0) {
                    maxLength = Math.max(maxLength, indexList.getLast() - indexList.getFirst() + 1);
                }
                size = indexList.size();
            }
        }
        return maxLength;
    }
}
