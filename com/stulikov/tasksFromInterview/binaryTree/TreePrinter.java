package com.stulikov.tasksFromInterview.binaryTree;

public class TreePrinter {
    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1);

        // Отступы
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        // Значение узла
        System.out.println(node.val);

        printTree(node.left, depth + 1);
    }
}