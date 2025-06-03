package com.stulikov.tasksFromInterview.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalRecursive {

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
            inorderHelper(root, result);
            return result;
        }

        private static void inorderHelper(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            // 1. Обходим левое поддерево
            inorderHelper(node.left, result);

            // 2. Добавляем значение текущего узла
            result.add(node.val);

            // 3. Обходим правое поддерево
            inorderHelper(node.right, result);
        }


}
