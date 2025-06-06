package com.stulikov.tasksFromInterview.binaryTree;

public class DFS {

    //Рекурсивный обход дерева в глубину
    public static void dfs(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " "); // preorder (обрабатываем узел)

        dfs(root.left);                  // идём налево
        dfs(root.right);                 // идём направо
    }
}
