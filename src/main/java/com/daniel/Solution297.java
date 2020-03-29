package com.daniel;

import com.daniel.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel Xia
 * @since 2019-07-04 20:16
 */
public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String path = root.val + "_";
        path += serialize(root.left);
        path += serialize(root.right);
        return path;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : datas) {
            queue.add(s);
        }
        return process(queue);
    }

    private TreeNode process(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = process(queue);
        node.right = process(queue);
        return node;
    }

}
