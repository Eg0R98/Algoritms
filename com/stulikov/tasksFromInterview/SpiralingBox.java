package com.stulikov.tasksFromInterview;

public class SpiralingBox {

    public static void main(String[] args) {
        int[][] box = createBox(5, 8);
        printMatrix(box);
    }

    public static int[][] createBox(int width, int n) {
        int[][] result = new int[n][width];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < width; col++) {
                int top = row;
                int bottom = n - 1 - row;
                int left = col;
                int right = width - 1 - col;
                result[row][col] = Math.min(Math.min(top, bottom), Math.min(left, right)) + 1;
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


}
