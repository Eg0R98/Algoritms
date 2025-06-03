package com.stulikov.tasksFromInterview.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        // Пример дерева:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        List<Integer> inorder = preorderTraversal(root);
        System.out.println(inorder);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }
}
