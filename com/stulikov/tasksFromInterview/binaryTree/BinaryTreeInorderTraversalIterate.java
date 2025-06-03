package com.stulikov.tasksFromInterview.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalIterate {

    public static void main(String[] args) {
        // Пример дерева:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        List<Integer> inorder = inorderTraversal(root);
        System.out.println(inorder); // Ожидаем [1, 3, 2]
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Спускаемся влево, пока есть куда
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Берем из стека верхний элемент
            current = stack.pop();
            result.add(current.val);

            // Переходим в правое поддерево
            current = current.right;
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
