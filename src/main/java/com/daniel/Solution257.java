package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/19 16:42
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, String.valueOf(root.val)));

        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();

            if (curPair.node.left != null) {
                queue.add(new Pair(curPair.node.left, curPair.path + "->" + curPair.node.left.val));
            }
            if (curPair.node.right != null) {
                queue.add(new Pair(curPair.node.right, curPair.path + "->" + curPair.node.right.val));
            }

            if (curPair.node.left == null && curPair.node.right == null) {
                pathList.add(curPair.path);
            }
        }
        return pathList;
    }

    private static class Pair {
        private TreeNode node;
        private String path;

        public Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
}
