package com.stulikov.tasksFromInterview.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Обход дерева в ширину
public class BFS {

    public static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
