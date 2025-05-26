package com.stulikov.tasksFromInterview.binaryTree;

public class BinaryTree {
    TreeNode root;

    // Вставка в бинарное дерево поиска (BST)
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else {
            node.right = insertRecursive(node.right, val);
        }
        return node;
    }

    // Inorder (лево - корень - право)
    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    // Preorder (корень - лево - право)
    public void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder (лево - право - корень)
    public void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }
}
