package com.stulikov.tasksFromInterview.binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Вставим значения в дерево
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        TreePrinter.printTree(tree.root);
    }
}
